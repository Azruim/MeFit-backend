package fi.experis.mefit.services;

import fi.experis.mefit.models.Program;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgramService {
    ResponseEntity<Program> addProgram(Program program);
    ResponseEntity<Program> getProgramById(Long programId);
    ResponseEntity<Program> updateProgramById(Long programId, Program program);
    ResponseEntity<String> deleteProgramById(Long programId);
    ResponseEntity<List<Program>> getAllPrograms();
}
