package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.WorkoutDTO;
import fi.experis.mefit.models.entities.Workout;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkoutService {
    ResponseEntity<String> addWorkout(WorkoutDTO workout);
    ResponseEntity<Workout> getWorkoutById(Long workoutId);
    ResponseEntity<String> updateWorkout(Long workoutId, WorkoutDTO workout);
    ResponseEntity<String> deleteWorkoutById(Long workoutId);
    ResponseEntity<List<Workout>> getAllWorkouts();
}