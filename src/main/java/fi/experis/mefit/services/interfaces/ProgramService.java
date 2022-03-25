package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.getDtos.ProgramGetDTO;
import fi.experis.mefit.models.dtos.postDtos.ProgramPostDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgramService {
    ResponseEntity<String> addProgram(ProgramPostDTO program);
    ResponseEntity<ProgramGetDTO> getProgramById(Long programId);
    ResponseEntity<String> updateProgramById(Long programId, ProgramPostDTO program);
    ResponseEntity<String> deleteProgramById(Long programId);
    ResponseEntity<List<ProgramGetDTO>> getAllPrograms();
}