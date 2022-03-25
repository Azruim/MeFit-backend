package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.exerciseDtos.post.ExercisePostDTO;
import fi.experis.mefit.models.entities.Exercise;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExerciseService {
    ResponseEntity<String> addExercise(ExercisePostDTO exercise);
    ResponseEntity<Exercise> getExerciseById(Long exerciseId);
    ResponseEntity<String> updateExercise(Long exerciseId, ExercisePostDTO exercise);
    ResponseEntity<String> deleteExerciseById(Long exercise);
    ResponseEntity<List<Exercise>> getAllExercises();
}
