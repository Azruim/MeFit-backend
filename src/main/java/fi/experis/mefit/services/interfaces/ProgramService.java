package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.programDtos.GetProgramDTO;
import fi.experis.mefit.models.dtos.programDtos.CreateProgramDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgramService {
    ResponseEntity<String> addProgram(CreateProgramDTO program);
    ResponseEntity<GetProgramDTO> getProgramById(Long programId);
    ResponseEntity<String> updateProgramById(Long programId, CreateProgramDTO program);
    ResponseEntity<String> deleteProgramById(Long programId);
    ResponseEntity<List<GetProgramDTO>> getAllPrograms();
}