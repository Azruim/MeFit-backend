package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.exerciseDtos.CreateExerciseDTO;
import fi.experis.mefit.models.entities.Exercise;
import fi.experis.mefit.repositories.ExerciseRepository;
import fi.experis.mefit.services.interfaces.ExerciseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    private Exercise convertToEntity(CreateExerciseDTO createExerciseDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(createExerciseDTO, Exercise.class);
    }

    @Override
    public ResponseEntity<String> addExercise(CreateExerciseDTO createExerciseDTO) {
        try {
            Exercise exercise = convertToEntity(createExerciseDTO);
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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
    public ResponseEntity<String> updateExercise(Long exerciseId, CreateExerciseDTO createExerciseDTO) {
        try {
            Exercise exercise = convertToEntity(createExerciseDTO);
            Optional<Exercise> existingExercise = exerciseRepository.findById(exerciseId);
            if (existingExercise.isPresent()) {
                exercise.setExerciseId(exerciseId);
                Exercise updatedExercise = exerciseRepository.save(exercise);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/exercises/" + updatedExercise.getExerciseId());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteExerciseById(Long exerciseId) {
        try {
            exerciseRepository.deleteById(exerciseId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
