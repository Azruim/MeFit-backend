package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Workout;
import fi.experis.mefit.services.WorkoutService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/workouts")
@SecurityRequirement(name = "keycloak_implicit")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{workoutId}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long workoutId) {
        return workoutService.getWorkoutById(workoutId);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_contributor')")
    public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout) {
        return workoutService.addWorkout(workout);
    }

    @PatchMapping("/{workoutId}")
    @PreAuthorize("hasRole('ROLE_contributor')")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long workoutId, @RequestBody Workout workout) {
        return workoutService.updateWorkout(workoutId, workout);
    }

    @DeleteMapping("/{workoutId}")
    @PreAuthorize("hasRole('ROLE_contributor')")
    public ResponseEntity<String> deleteWorkout(@PathVariable Long workoutId) {
        return workoutService.deleteWorkoutById(workoutId);
    }
}
