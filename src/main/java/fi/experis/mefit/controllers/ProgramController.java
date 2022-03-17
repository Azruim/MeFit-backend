package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Program;
import fi.experis.mefit.services.ProgramService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/programs")
@SecurityRequirement(name = "keycloak_implicit")
@PreAuthorize("hasRole('ROLE_regular-user')")
public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    public ResponseEntity<List<Program>> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{programId}")
    public ResponseEntity<Program> getProgramById(@PathVariable Long programId) {
        return programService.getProgramById(programId);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_contributor', 'ROLE_admin')")
    public ResponseEntity<String> addProgram(@RequestBody Program program) {
        return programService.addProgram(program);
    }

    @PatchMapping("/{programId}")
    @PreAuthorize("hasAnyRole('ROLE_contributor', 'ROLE_admin')")
    public ResponseEntity<String> updateProgram(@PathVariable Long programId, @RequestBody Program program) {
        return programService.updateProgramById(programId, program);
    }

    @DeleteMapping("{programId}")
    @PreAuthorize("hasAnyRole('ROLE_contributor', 'ROLE_admin')")
    public ResponseEntity<String> deleteProgram(@PathVariable Long programId) {
        return programService.deleteProgramById(programId);
    }
}
