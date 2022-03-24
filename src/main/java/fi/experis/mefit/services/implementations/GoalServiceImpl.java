package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.postDtos.GoalDTO;
import fi.experis.mefit.models.entities.*;
import fi.experis.mefit.repositories.*;
import fi.experis.mefit.services.interfaces.GoalService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;
    private final ProfileRepository profileRepository;
    private final ProgramRepository programRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public GoalServiceImpl(GoalRepository goalRepository, ProfileRepository profileRepository,
                           ProgramRepository programRepository, WorkoutRepository workoutRepository,
                           ExerciseRepository exerciseRepository) {
        this.goalRepository = goalRepository;
        this.profileRepository = profileRepository;
        this.programRepository = programRepository;
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
    }

    private Goal convertToEntity(GoalDTO goalDTO) {
        Goal goal = modelMapper.map(goalDTO, Goal.class);
        if (goal.getProfile() != null) goal.setProfile(profileRepository.getById(goal.getProfile().getProfileId()));
        if (goal.getProgram() != null) goal.setProgram(programRepository.getById(goal.getProgram().getProgramId()));
        if (goal.getExercises() != null) goal.setExercises(exerciseRepository.findAllById(goal.getExercises().stream()
                .map(Exercise::getExerciseId).collect(Collectors.toList())));
        if (goal.getWorkouts() != null) goal.setWorkouts(workoutRepository.findAllById(goal.getWorkouts().stream()
                .map(Workout::getWorkoutId).collect(Collectors.toList())));
        return goal;
    }

    @Override
    public ResponseEntity<String> addGoal(GoalDTO goalDTO) {
        try {
            Goal goal = convertToEntity(goalDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/goals/" + goalRepository.save(goal).getGoalId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Goal> getGoalById(Long goalId) {
        try {
            if (goalRepository.findById(goalId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(goalRepository.findById(goalId).get());
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
                goalDTO.setGoalId(goalId);
                Goal goal = convertToEntity(goalDTO);
                Goal updatedGoal = goalRepository.save(goal);
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
