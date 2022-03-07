package fi.experis.mefit.service;

import fi.experis.mefit.models.Exercise;

import java.util.List;

public interface ExerciseService {
    Exercise addExercise(Exercise exercise);
    Exercise getExerciseById(Long exerciseId);
    void updateExercise(Long exerciseId, Exercise exercise);
    void deleteExerciseById(Long exercise);
    List<Exercise> getAllExercises();
}
