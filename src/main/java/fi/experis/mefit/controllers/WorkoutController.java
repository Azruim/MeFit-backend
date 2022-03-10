package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Workout;
import fi.experis.mefit.services.WorkoutService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/workouts")
@SecurityRequirement(name = "keycloak_implicit")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping("")
    public List<Workout> getAllWorkouts(Authentication authentication, Principal principal) {
        System.out.println(authentication.getCredentials());
        System.out.println(principal.toString());
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{workoutId}")
    public Workout getWorkoutById(@PathVariable Long workoutId) {
        return workoutService.getWorkoutById(workoutId);
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
