package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.Workout;
import fi.experis.mefit.repositories.WorkoutRepository;
import fi.experis.mefit.services.interfaces.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public ResponseEntity<Workout> addWorkout(Workout workout) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(workoutRepository.save(workout));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Workout> getWorkoutById(Long workoutId) {
        try {
            if (workoutRepository.findById(workoutId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(workoutRepository.findById(workoutId).get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Workout>> getAllWorkouts(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(workoutRepository.findAll());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Workout> updateWorkout(Long workoutId, Workout workout) {
        try {
            if (workoutRepository.existsById(workoutId)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(workoutRepository.save(workout));
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteWorkoutById(Long workoutId) {
        try {
            workoutRepository.deleteById(workoutId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
