package fi.experis.mefit.controllers;

import fi.experis.mefit.models.dtos.WorkoutDTO;
import fi.experis.mefit.models.entities.Workout;
import fi.experis.mefit.services.interfaces.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "Get all workouts")
    @GetMapping
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @Operation(summary = "Get workout by id")
    @GetMapping("/{workoutId}")
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<Workout> getWorkoutById(@Parameter(description = "Id of workout to be searched") @PathVariable Long workoutId) {
        return workoutService.getWorkoutById(workoutId);
    }

    @Operation(summary = "Create a new workout")
    @PostMapping("")
    public ResponseEntity<String> addWorkout(@RequestBody WorkoutDTO workout) {
        return workoutService.addWorkout(workout);
    }

    @Operation(summary = "Update workout by id")
    @PatchMapping("/{workoutId}")
    public ResponseEntity<String> updateWorkout(@Parameter(description = "Id of workout to be updated") @PathVariable Long workoutId, @RequestBody WorkoutDTO workout) {
        return workoutService.updateWorkout(workoutId, workout);
    }

    @Operation(summary = "Delete workout by id")
    @DeleteMapping("/{workoutId}")
    public ResponseEntity<String> deleteWorkout(@Parameter(description = "Id of workout to be deleted") @PathVariable Long workoutId) {
        return workoutService.deleteWorkoutById(workoutId);
    }
}