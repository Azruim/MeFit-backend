package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.Workout;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkoutService {
    ResponseEntity<Workout> addWorkout(Workout workout);
    ResponseEntity<Workout> getWorkoutById(Long workoutId);
    ResponseEntity<Workout> updateWorkout(Long workoutId, Workout workout);
    ResponseEntity<String> deleteWorkoutById(Long workoutId);
    ResponseEntity<List<Workout>> getAllWorkouts();
}
