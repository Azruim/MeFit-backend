package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.entities.Workout;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface WorkoutService {
    ResponseEntity<String> addWorkout(Workout workout);
    ResponseEntity<Workout> getWorkoutById(Long workoutId);
    ResponseEntity<String> updateWorkout(Long workoutId, Map<Object, Object> fields);
    ResponseEntity<String> deleteWorkoutById(Long workoutId);
    ResponseEntity<List<Workout>> getAllWorkouts();
}
