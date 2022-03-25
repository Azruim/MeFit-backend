package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.workoutDtos.get.WorkoutGetDTO;
import fi.experis.mefit.models.dtos.workoutDtos.post.WorkoutPostDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkoutService {
    ResponseEntity<String> addWorkout(WorkoutPostDTO workout);
    ResponseEntity<WorkoutGetDTO> getWorkoutById(Long workoutId);
    ResponseEntity<String> updateWorkout(Long workoutId, WorkoutPostDTO workout);
    ResponseEntity<String> deleteWorkoutById(Long workoutId);
    ResponseEntity<List<WorkoutGetDTO>> getAllWorkouts();
}