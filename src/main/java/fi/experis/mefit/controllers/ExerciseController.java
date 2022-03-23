package fi.experis.mefit.controllers;

import fi.experis.mefit.models.entities.Exercise;
import fi.experis.mefit.services.interfaces.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirement(name = "keycloak_implicit")
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/exercises")
@PreAuthorize("hasAnyRole('ROLE_admin', 'ROLE_contributor')")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @Operation(summary = "Get all exercises")
    @GetMapping
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @Operation(summary = "Get exercise by id")
    @GetMapping("/{exerciseId}")
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<Exercise> getExerciseById(@Parameter(description = "Id of exercise to be searched") @PathVariable Long exerciseId) {
        return exerciseService.getExerciseById(exerciseId);
    }

    @Operation(summary = "Create a new exercise")
    @PostMapping
    public ResponseEntity<String> addExercise(@RequestBody Exercise exercise) {
        return exerciseService.addExercise(exercise);
    }

    @Operation(summary = "Update exercise by id")
    @PatchMapping("/{exerciseId}")
    public ResponseEntity<String> updateExercise(@Parameter(description = "Id of exercise to be updated") @PathVariable Long exerciseId, @RequestBody Exercise exercise) {
        return exerciseService.updateExercise(exerciseId, exercise);
    }

    @Operation(summary = "Delete exercise by id")
    @DeleteMapping("/{exerciseId}")
    public ResponseEntity<String> deleteExercise(@Parameter(description = "Id of exercise to be deleted")@PathVariable Long exerciseId) {
        return exerciseService.deleteExerciseById(exerciseId);
    }
}
