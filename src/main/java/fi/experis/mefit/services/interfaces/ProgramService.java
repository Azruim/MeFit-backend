package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.Program;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgramService {
    ResponseEntity<String> addProgram(Program program);
    ResponseEntity<Program> getProgramById(Long programId);
    ResponseEntity<String> updateProgramById(Long programId, Program program);
    ResponseEntity<String> deleteProgramById(Long programId);
    ResponseEntity<List<Program>> getAllPrograms();
}
