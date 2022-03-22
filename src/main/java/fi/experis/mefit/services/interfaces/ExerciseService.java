package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.entities.Exercise;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ExerciseService {
    ResponseEntity<String> addExercise(Exercise exercise);
    ResponseEntity<Exercise> getExerciseById(Long exerciseId);
    ResponseEntity<String> updateExercise(Long exerciseId, Map<Object, Object> fields);
    ResponseEntity<String> deleteExerciseById(Long exercise);
    ResponseEntity<List<Exercise>> getAllExercises();
}
