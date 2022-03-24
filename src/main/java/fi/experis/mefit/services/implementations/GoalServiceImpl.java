package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.goalDto.GoalDTO;
import fi.experis.mefit.models.entities.*;
import fi.experis.mefit.repositories.*;
import fi.experis.mefit.services.interfaces.GoalService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;
    private final ProfileRepository profileRepository;
    private final ProgramRepository programRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;
    private final GoalWorkoutRepository goalWorkoutRepository;
    private final GoalExerciseRepository goalExerciseRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    public GoalServiceImpl(GoalRepository goalRepository, ProfileRepository profileRepository,
                           ProgramRepository programRepository, WorkoutRepository workoutRepository,
                           ExerciseRepository exerciseRepository, GoalWorkoutRepository goalWorkoutRepository,
                           GoalExerciseRepository goalExerciseRepository) {
        this.goalRepository = goalRepository;
        this.profileRepository = profileRepository;
        this.programRepository = programRepository;
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
        this.goalWorkoutRepository = goalWorkoutRepository;
        this.goalExerciseRepository = goalExerciseRepository;
    }

    private Goal convertToEntity(GoalDTO goalDTO) {
        Goal goal = modelMapper.map(goalDTO, Goal.class);
        if (goal.getProfile() != null) goal.setProfile(profileRepository.getById(goal.getProfile().getProfileId()));
        if (goal.getProgram() != null) goal.setProgram(programRepository.getById(goal.getProgram().getProgramId()));
        if (goal.getExercises() != null) {
            // TODO: POST
            //CREATE NEW GOAL WITH EXERCISE
            List<Exercise> exercises = goal.getExercises().stream().map(exercise -> {
                Optional<Exercise> oldExercise = exerciseRepository.findById(exercise.getExerciseId());
                return oldExercise.orElse(null);
            }).toList();
            goal.setExercises(exercises);
        }
        if (goal.getWorkouts() != null) {
            List<GoalWorkout> goalWorkouts = goal.getGoalWorkouts().stream().map(goalWorkout -> {
                if (goalWorkout.getGoalWorkoutId() != null) {
                    Optional<GoalWorkout> optionalGoalWorkout = goalWorkoutRepository.findById(goalWorkout.getGoalWorkoutId());
                    if (optionalGoalWorkout.isPresent()) {
                        optionalGoalWorkout.get().setComplete(goalWorkout.isComplete());
                        goalWorkoutRepository.save(optionalGoalWorkout.get());
                        return optionalGoalWorkout.get();
                    }
                    return null;
                }else {
                    GoalWorkout newGoalWorkout = new GoalWorkout();
                    Optional<Workout> workout = workoutRepository.findById(goalWorkout.getWorkout().getWorkoutId());
                    if (workout.isPresent()) {
                        newGoalWorkout.setComplete(goalWorkout.isComplete());
                        newGoalWorkout.setWorkout(workout.get());
                    }
                    return newGoalWorkout;
                }
            }).toList();
            goal.setGoalWorkouts(goalWorkouts);
            goal.setWorkouts(workoutRepository.findAllById(goal.getWorkouts().stream()
                    .map(Workout::getWorkoutId).toList()));
        }
        goal.getGoalExercises().forEach(System.out::println);
        return goal;
    }

    private GoalDTO convertToDTO(Goal goal) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(goal, GoalDTO.class);
    }

    @Override
    public ResponseEntity<String> addGoal(GoalDTO goalDTO) {
        try {
            Goal goal = convertToEntity(goalDTO);

            Goal newGoal = goalRepository.save(goal);



            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/goals/" + newGoal.getGoalId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<GoalDTO> getGoalById(Long goalId) {
        try {
            if (goalRepository.findById(goalId).isPresent()) {
                Goal goal = goalRepository.findById(goalId).get();
                GoalDTO goalDTO = convertToDTO(goal);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(goalDTO);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateGoal(Long goalId, GoalDTO goalDTO) {
        try {
            Optional<Goal> oldGoal = goalRepository.findById(goalId);
            if (oldGoal.isPresent()) {
                Goal goal = convertToEntity(goalDTO);
                goal.setGoalId(goalId);
                Goal updatedGoal = goalRepository.save(goal);
                if (goal.getGoalWorkouts() != null) {
                    goal.getGoalWorkouts().forEach(goalWorkout -> {
                        goalWorkout.setGoal(updatedGoal);
                        goalWorkoutRepository.save(goalWorkout);
                    });
                }
                if (goal.getGoalExercises() != null) {
                    goal.getGoalExercises().forEach(goalExercise -> {
                        goalExercise.setGoal(updatedGoal);
                    });
                    goalExerciseRepository.saveAll(goal.getGoalExercises());
                }
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/goals/" + updatedGoal.getGoalId());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteGoalById(Long goalId) {
        try {
            goalRepository.deleteById(goalId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
