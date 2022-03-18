package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Program;
import fi.experis.mefit.services.interfaces.ProgramService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/programs")
@SecurityRequirement(name = "keycloak_implicit")
@PreAuthorize("hasAnyRole('ROLE_contributor', 'ROLE_admin')")
public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<List<Program>> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{programId}")
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<Program> getProgramById(@PathVariable Long programId) {
        return programService.getProgramById(programId);
    }

    @PostMapping
    public ResponseEntity<String> addProgram(@RequestBody Program program) {
        return programService.addProgram(program);
    }

    @PatchMapping("/{programId}")
    public ResponseEntity<String> updateProgram(@PathVariable Long programId, @RequestBody Program program) {
        return programService.updateProgramById(programId, program);
    }

    @DeleteMapping("{programId}")
    public ResponseEntity<String> deleteProgram(@PathVariable Long programId) {
        return programService.deleteProgramById(programId);
    }
}
