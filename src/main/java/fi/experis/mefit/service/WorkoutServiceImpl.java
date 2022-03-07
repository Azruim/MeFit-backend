package fi.experis.mefit.service;

import fi.experis.mefit.models.Workout;
import fi.experis.mefit.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService{
    @Autowired
    private WorkoutRepository workoutRepository;
    @Override
    public Workout addWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }
    @Override
    public Workout getWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId).get();
    }
    @Override
    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    @Override
    public void updateWorkout(Long workoutId, Workout workout) {
        // check if the user with the passed id exists or not
        if (workoutRepository.findById(workoutId).isPresent()) {
            // If user exists then updated
            workoutRepository.save(workout);
        }
    }

    @Override
    public void deleteWorkoutById(Long workoutId) {
        try {
            workoutRepository.deleteById(workoutId);
        }catch(DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
