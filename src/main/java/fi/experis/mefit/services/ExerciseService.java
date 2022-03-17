package fi.experis.mefit.services;

import fi.experis.mefit.models.Exercise;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExerciseService {
    ResponseEntity<String> addExercise(Exercise exercise);
    ResponseEntity<Exercise> getExerciseById(Long exerciseId);
    ResponseEntity<String> updateExercise(Long exerciseId, Exercise exercise);
    ResponseEntity<String> deleteExerciseById(Long exercise);
    ResponseEntity<List<Exercise>> getAllExercises();
}
