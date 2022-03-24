package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.postDtos.ProgramDTO;
import fi.experis.mefit.models.entities.Program;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgramService {
    ResponseEntity<String> addProgram(ProgramDTO program);
    ResponseEntity<Program> getProgramById(Long programId);
    ResponseEntity<String> updateProgramById(Long programId, ProgramDTO program);
    ResponseEntity<String> deleteProgramById(Long programId);
    ResponseEntity<List<Program>> getAllPrograms();
}