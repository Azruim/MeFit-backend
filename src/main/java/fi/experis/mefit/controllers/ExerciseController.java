package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Exercise;
import fi.experis.mefit.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercises")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @GetMapping("")
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @PostMapping("")
    public Exercise addExercise(@RequestBody Exercise exercise) {
        return exerciseService.addExercise(exercise);
    }

    @PutMapping("/{exerciseId}")
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
