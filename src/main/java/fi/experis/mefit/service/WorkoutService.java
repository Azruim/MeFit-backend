package fi.experis.mefit.service;

import fi.experis.mefit.models.Workout;

import java.util.List;

public interface WorkoutService {
    Workout addWorkout(Workout workout);
    Workout getWorkoutById(Long workoutId);
    void updateWorkout(Long workoutId, Workout workout);
    void deleteWorkoutById(Long workoutId);
    List<Workout> getAllWorkouts();
}
