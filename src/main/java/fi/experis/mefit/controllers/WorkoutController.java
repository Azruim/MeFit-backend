package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Workout;
import fi.experis.mefit.services.WorkoutService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/workouts")
@SecurityRequirement(name = "keycloak_implicit")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping("")
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{workoutId}")
    public Workout getWorkoutById(@PathVariable Long workoutId) {
        return workoutService.getWorkoutById(workoutId);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_contributor')")
    public Workout addWorkout(@RequestBody Workout workout) {
        return workoutService.addWorkout(workout);
    }

    @PatchMapping("/{workoutId}")
    @PreAuthorize("hasRole('ROLE_contributor')")
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
    @PreAuthorize("hasRole('ROLE_contributor')")
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
