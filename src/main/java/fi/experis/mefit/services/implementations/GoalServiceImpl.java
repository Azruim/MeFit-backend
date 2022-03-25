package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.goalDto.get.GoalGetDTO;
import fi.experis.mefit.models.dtos.goalDto.post.GoalPostDTO;
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
    private final GoalWorkoutRepository goalWorkoutRepository;
    private final GoalExerciseRepository goalExerciseRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    public GoalServiceImpl(GoalRepository goalRepository, GoalWorkoutRepository goalWorkoutRepository,
                           GoalExerciseRepository goalExerciseRepository) {
        this.goalRepository = goalRepository;
        this.goalWorkoutRepository = goalWorkoutRepository;
        this.goalExerciseRepository = goalExerciseRepository;
    }

    private Goal convertToEntity(GoalPostDTO goalPostDTO) {
        return modelMapper.map(goalPostDTO, Goal.class);
    }

    @Override
    public ResponseEntity<String> addGoal(GoalPostDTO goalPostDTO) {
        try {
            Goal goalEntity = convertToEntity(goalPostDTO);
            Goal newGoal = goalRepository.save(goalEntity);
            if (goalEntity.getGoalWorkouts() != null) {
                List<GoalWorkout> goalWorkouts = goalWorkoutRepository.
                        saveAll(goalEntity.getGoalWorkouts().stream().
                                peek(goalWorkout -> {
                                    goalWorkout.setGoal(newGoal);
                                    goalWorkout.setGoalWorkoutId(null);
                                }).toList());
                newGoal.setGoalWorkouts(goalWorkouts);
            }
            if (goalEntity.getGoalExercises() != null) {
                List<GoalExercise> goalExercises = goalExerciseRepository.
                        saveAll(goalEntity.getGoalExercises().stream().
                                peek(goalExercise -> {
                                    goalExercise.setGoal(newGoal);
                                    goalExercise.setGoalExerciseId(null);
                                }).toList());
                newGoal.setGoalExercises(goalExercises);
            }
            Goal goal = goalRepository.save(newGoal);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/goals/" + goal.getGoalId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<GoalGetDTO> getGoalById(Long goalId) {
        try {
            if (goalRepository.findById(goalId).isPresent()) {
                Goal goal = goalRepository.findById(goalId).get();
                GoalGetDTO goalGetDTO = modelMapper.map(goal, GoalGetDTO.class);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(goalGetDTO);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateGoal(Long goalId, GoalPostDTO goalPostDTO) {
        try {
            Optional<Goal> oldGoal = goalRepository.findById(goalId);
            if (oldGoal.isPresent()) {
                Goal goalEntity = convertToEntity(goalPostDTO);
                goalEntity.setGoalId(goalId);
                if (goalEntity.getGoalWorkouts() != null) {
                    List<GoalWorkout> goalWorkouts = goalWorkoutRepository.findAllById(oldGoal.get().getGoalWorkouts().
                            stream().map(GoalWorkout::getGoalWorkoutId).toList());
                    List<GoalWorkout> goalWorkoutEntities = goalEntity.getGoalWorkouts();
                    List<GoalWorkout> newGoalWorkouts = new ArrayList<>();
                    for (int i = 0; i < goalWorkouts.size(); i++) {
                        goalWorkouts.get(i).setCompleted(goalWorkoutEntities.get(i).isCompleted());
                        newGoalWorkouts.add(goalWorkoutRepository.save(goalWorkouts.get(i)));

                    }
                    goalEntity.setGoalWorkouts(newGoalWorkouts);
                }
                if (goalEntity.getGoalExercises() != null) {
                    List<GoalExercise> goalExercises = goalExerciseRepository.findAllById(oldGoal.get().getGoalExercises().
                            stream().map(GoalExercise::getGoalExerciseId).toList());
                    List<GoalExercise> goalExerciseEntities = goalEntity.getGoalExercises();
                    List<GoalExercise> newGoalExercises = new ArrayList<>();
                    for (int i = 0; i < goalExercises.size(); i++) {
                        goalExercises.get(i).setCompleted(goalExerciseEntities.get(i).isCompleted());
                        newGoalExercises.add(goalExerciseRepository.save(goalExercises.get(i)));
                    }
                    goalEntity.setGoalExercises(newGoalExercises);
                }
                Goal goal = goalRepository.save(goalEntity);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/goals/" + goal.getGoalId());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteGoalById(Long goalId) {
        try {
            goalRepository.deleteById(goalId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
