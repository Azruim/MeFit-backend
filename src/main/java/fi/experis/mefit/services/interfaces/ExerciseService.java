package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.postDtos.ExerciseDTO;
import fi.experis.mefit.models.entities.Exercise;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ExerciseService {
    ResponseEntity<String> addExercise(ExerciseDTO exercise);
    ResponseEntity<Exercise> getExerciseById(Long exerciseId);
    ResponseEntity<String> updateExercise(Long exerciseId, ExerciseDTO exercise);
    ResponseEntity<String> deleteExerciseById(Long exercise);
    ResponseEntity<List<Exercise>> getAllExercises();
}
