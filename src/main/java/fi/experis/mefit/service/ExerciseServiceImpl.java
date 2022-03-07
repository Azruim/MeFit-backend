package fi.experis.mefit.service;

import fi.experis.mefit.models.Exercise;
import fi.experis.mefit.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Override
    public Exercise addExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }
    @Override
    public Exercise getExerciseById(Long exerciseId) {
        return exerciseRepository.findById(exerciseId).get();
    }
    @Override
    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAll();
    }

    @Override
    public void updateExercise(Long exerciseId, Exercise exercise) {
        // check if the user with the passed id exists or not
        if (exerciseRepository.findById(exerciseId).isPresent()) {
            // If user exists then updated
            exerciseRepository.save(exercise);
        }
    }

    @Override
    public void deleteExerciseById(Long exerciseId) {
        try {
            exerciseRepository.deleteById(exerciseId);
        }catch(DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
