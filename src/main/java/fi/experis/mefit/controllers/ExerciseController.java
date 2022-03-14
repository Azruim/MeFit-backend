package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Exercise;
import fi.experis.mefit.services.ExerciseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@SecurityRequirement(name = "keycloak_implicit")
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/exercises")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @GetMapping("")
    public ResponseEntity<Object> getAllExercises() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(exerciseService.getAllExercises());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{exerciseId}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long exerciseId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(exerciseService.getExerciseById(exerciseId));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_contributor')")
    public ResponseEntity<String> addExercise(@RequestBody Exercise exercise) {
        try {
            exerciseService.addExercise(exercise);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{exerciseId}")
    @PreAuthorize("hasRole('ROLE_contributor')")
    public ResponseEntity<String> updateExercise(@PathVariable Long exerciseId, @RequestBody Exercise exercise) {
        try {
            exerciseService.updateExercise(exerciseId, exercise);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{exerciseId}")
    @PreAuthorize("hasRole('ROLE_contributor')")
    public ResponseEntity<String> deleteExercise(@PathVariable Long exerciseId) {
        try {
            exerciseService.deleteExerciseById(exerciseId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(RuntimeException e){
            // log the error message
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
