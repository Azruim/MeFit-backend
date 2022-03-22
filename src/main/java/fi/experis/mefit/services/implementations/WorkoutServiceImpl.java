package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.entities.Workout;
import fi.experis.mefit.repositories.WorkoutRepository;
import fi.experis.mefit.services.interfaces.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public ResponseEntity<String> addWorkout(Workout workout) {
        try {
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
    public ResponseEntity<String> updateWorkout(Long workoutId, Map<Object, Object> fields) {
        try {
            Optional<Workout> workout = workoutRepository.findById(workoutId);
            if (workout.isPresent()) {
                fields.forEach((Object key, Object value) -> {
                    Field field = ReflectionUtils.findField(Workout.class, (String) key);
                    assert field != null;
                    field.trySetAccessible();
                    ReflectionUtils.setField(field, workout.get(), value);
                });
                Workout updatedWorkout = workoutRepository.save(workout.get());
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/workouts/" + updatedWorkout.getWorkoutId());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
