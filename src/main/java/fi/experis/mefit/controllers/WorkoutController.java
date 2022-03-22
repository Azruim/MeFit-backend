package fi.experis.mefit.controllers;

import fi.experis.mefit.models.entities.Workout;
import fi.experis.mefit.services.interfaces.WorkoutService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/workouts")
@SecurityRequirement(name = "keycloak_implicit")
@PreAuthorize("hasAnyRole('ROLE_contributor', 'ROLE_admin')")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{workoutId}")
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long workoutId) {
        return workoutService.getWorkoutById(workoutId);
    }

    @PostMapping("")
    public ResponseEntity<String> addWorkout(@RequestBody Workout workout) {
        return workoutService.addWorkout(workout);
    }

    @PatchMapping("/{workoutId}")
    public ResponseEntity<String> updateWorkout(@PathVariable Long workoutId, @RequestBody Map<Object, Object> fields) {
        return workoutService.updateWorkout(workoutId, fields);
    }

    @DeleteMapping("/{workoutId}")
    public ResponseEntity<String> deleteWorkout(@PathVariable Long workoutId) {
        return workoutService.deleteWorkoutById(workoutId);
    }
}
