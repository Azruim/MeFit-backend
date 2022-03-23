package fi.experis.mefit.controllers;

import fi.experis.mefit.models.entities.Program;
import fi.experis.mefit.services.interfaces.ProgramService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @Operation(summary = "Get all programs")
    @GetMapping
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<List<Program>> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @Operation(summary = "Get program by id")
    @GetMapping("/{programId}")
    @PreAuthorize("hasRole('ROLE_regular-user')")
    public ResponseEntity<Program> getProgramById(@Parameter(description = "Id of program to be searched") @PathVariable Long programId) {
        return programService.getProgramById(programId);
    }

    @Operation(summary = "Create a new program")
    @PostMapping
    public ResponseEntity<String> addProgram(@RequestBody Program program) {
        return programService.addProgram(program);
    }

    @Operation(summary = "Update program id")
    @PatchMapping("/{programId}")
    public ResponseEntity<String> updateProgram(@Parameter(description = "Id of program to be updated") @PathVariable Long programId, @RequestBody Map<Object, Object> fields) {
        return programService.updateProgramById(programId, fields);
    }

    @Operation(summary = "Delete program by id")
    @DeleteMapping("{programId}")
    public ResponseEntity<String> deleteProgram(@Parameter(description = "Id of program to be deleted") @PathVariable Long programId) {
        return programService.deleteProgramById(programId);
    }
}
