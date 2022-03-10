package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Program;
import fi.experis.mefit.services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/programs")
public class ProgramController {

    @Autowired
    ProgramService programService;

    @GetMapping("")
    public List<Program> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{programId}")
    public Program getProgramById(@PathVariable Long programId) {
        return programService.getProgramById(programId);
    }

    @PostMapping("")
    public Program addProgram(@RequestBody Program program) {
        return programService.addProgram(program);
    }

    @PutMapping("/{programId}")
    public ResponseEntity<String> updateProgram(@PathVariable Long programId, @RequestBody Program program) {
        try {
            programService.updateProgramById(programId, program);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{programId}")
    public ResponseEntity<String> deleteProgram(@PathVariable Long programId) {
        try {
            programService.deleteProgramById(programId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
