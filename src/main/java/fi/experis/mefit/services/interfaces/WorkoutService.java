package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.getDtos.WorkoutGetDTO;
import fi.experis.mefit.models.dtos.postDtos.WorkoutDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkoutService {
    ResponseEntity<String> addWorkout(WorkoutDTO workout);
    ResponseEntity<WorkoutGetDTO> getWorkoutById(Long workoutId);
    ResponseEntity<String> updateWorkout(Long workoutId, WorkoutDTO workout);
    ResponseEntity<String> deleteWorkoutById(Long workoutId);
    ResponseEntity<List<WorkoutGetDTO>> getAllWorkouts();
}