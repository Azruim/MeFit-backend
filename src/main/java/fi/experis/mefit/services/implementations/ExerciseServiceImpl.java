package fi.experis.mefit.services;

import fi.experis.mefit.models.Exercise;
import fi.experis.mefit.repositories.ExerciseRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public ResponseEntity<String> addExercise(Exercise exercise) {
        try {
            exerciseRepository.save(exercise);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Exercise> getExerciseById(Long exerciseId) {
        try {
            if (exerciseRepository.findById(exerciseId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(exerciseRepository.findById(exerciseId).get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Exercise>> getAllExercises() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(exerciseRepository.findAll());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Exercise> updateExercise(Long exerciseId, Exercise exercise) {
        try {
            if (exerciseRepository.findById(exerciseId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(exerciseRepository.save(exercise));
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteExerciseById(Long exerciseId) {
        try {
            exerciseRepository.deleteById(exerciseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
