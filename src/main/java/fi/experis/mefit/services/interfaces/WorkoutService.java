package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.workoutDtos.GetWorkoutDTO;
import fi.experis.mefit.models.dtos.workoutDtos.CreateWorkoutDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkoutService {
    ResponseEntity<String> addWorkout(CreateWorkoutDTO workout);
    ResponseEntity<GetWorkoutDTO> getWorkoutById(Long workoutId);
    ResponseEntity<String> updateWorkout(Long workoutId, CreateWorkoutDTO workout);
    ResponseEntity<String> deleteWorkoutById(Long workoutId);
    ResponseEntity<List<GetWorkoutDTO>> getAllWorkouts();
}