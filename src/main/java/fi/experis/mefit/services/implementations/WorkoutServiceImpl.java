package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.postDtos.WorkoutDTO;
import fi.experis.mefit.models.entities.Set;
import fi.experis.mefit.models.entities.Workout;
import fi.experis.mefit.repositories.ExerciseRepository;
import fi.experis.mefit.repositories.SetRepository;
import fi.experis.mefit.repositories.WorkoutRepository;
import fi.experis.mefit.services.interfaces.WorkoutService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final SetRepository setRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public WorkoutServiceImpl(WorkoutRepository workoutRepository, SetRepository setRepository, ExerciseRepository exerciseRepository) {
        this.workoutRepository = workoutRepository;
        this.setRepository = setRepository;
    }

    private Workout convertToEntity(WorkoutDTO workoutDTO) {
        Workout workout = modelMapper.map(workoutDTO, Workout.class);
        if (workout.getSets() != null) {
            List<Set> sets = workout.getSets();
            List<Set> newSets = new ArrayList<>();
            for (Set set : sets) {
                if (set.getSetId() == null) {
                    newSets.add(setRepository.save(set));
                } else {
                    Optional<Set> oldSet = setRepository.findById(set.getSetId());
                    if (oldSet.isPresent()) {
                        newSets.add(oldSet.get());
                    } else {
                        newSets.add(set);
                    }
                }

            }
            workout.setSets(newSets);
        }
        return workout;
    }

    @Override
    public ResponseEntity<String> addWorkout(WorkoutDTO workoutDTO) {
        try {
            Workout workout = convertToEntity(workoutDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/workouts/" + workoutRepository.save(workout).getWorkoutId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Workout> getWorkoutById(Long workoutId) {
        try {
            if (workoutRepository.findById(workoutId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(workoutRepository.findById(workoutId).get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Workout>> getAllWorkouts(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(workoutRepository.findAll());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateWorkout(Long workoutId, WorkoutDTO workoutDTO) {
        try {
            Workout workout = convertToEntity(workoutDTO);
            workout.setWorkoutId(workoutId);
            Workout updatedWorkout = workoutRepository.save(workout);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/workouts/" + updatedWorkout.getWorkoutId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteWorkoutById(Long workoutId) {
        try {
            workoutRepository.deleteById(workoutId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}