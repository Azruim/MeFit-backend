package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Workout;
import fi.experis.mefit.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workouts")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping("")
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @PostMapping("")
    public Workout addWorkout(@RequestBody Workout workout) {
        return workoutService.addWorkout(workout);
    }

    @PutMapping("/{workoutId}")
    public ResponseEntity<String> updateWorkout(@PathVariable Long workoutId, @RequestBody Workout workout) {
        try {
            workoutService.updateWorkout(workoutId, workout);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{workoutId}")
    public ResponseEntity<String> deleteWorkout(@PathVariable Long workoutId) {
        try {
            workoutService.deleteWorkoutById(workoutId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(RuntimeException e){
            // log the error message
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
