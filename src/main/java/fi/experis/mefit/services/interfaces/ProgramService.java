package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.entities.Program;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ProgramService {
    ResponseEntity<String> addProgram(Program program);
    ResponseEntity<Program> getProgramById(Long programId);
    ResponseEntity<String> updateProgramById(Long programId, Map<Object, Object> fields);
    ResponseEntity<String> deleteProgramById(Long programId);
    ResponseEntity<List<Program>> getAllPrograms();
}
