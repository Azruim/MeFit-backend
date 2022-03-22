package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.entities.Exercise;
import fi.experis.mefit.repositories.ExerciseRepository;
import fi.experis.mefit.services.interfaces.ExerciseService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public ResponseEntity<String> addExercise(Exercise exercise) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/exercises/" + exerciseRepository.save(exercise).getExerciseId());
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
                    .body(exerciseRepository.findAll()
                            .stream()
                            .sorted(Comparator.comparing(Exercise::getTargetMuscleGroup))
                            .collect(Collectors.toList()));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateExercise(Long exerciseId, Map<Object, Object> fields) {
        try {
            Optional<Exercise> exercise = exerciseRepository.findById(exerciseId);
            if (exercise.isPresent()) {
                fields.forEach((Object key, Object value) -> {
                    Field field = ReflectionUtils.findField(Exercise.class, (String) key);
                    assert field != null;
                    field.trySetAccessible();
                    ReflectionUtils.setField(field, exercise.get(), value);
                });
                Exercise updatedExercise = exerciseRepository.save(exercise.get());
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/exercises/" + updatedExercise.getExerciseId());
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
