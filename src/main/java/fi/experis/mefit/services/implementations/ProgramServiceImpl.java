package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.programDtos.GetProgramDTO;
import fi.experis.mefit.models.dtos.programDtos.CreateProgramDTO;
import fi.experis.mefit.models.entities.Program;
import fi.experis.mefit.models.entities.Workout;
import fi.experis.mefit.repositories.ProgramRepository;
import fi.experis.mefit.repositories.WorkoutRepository;
import fi.experis.mefit.services.interfaces.ProgramService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    private Program convertToEntity(CreateProgramDTO createProgramDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(createProgramDTO, Program.class);
    }

    @Override
    public ResponseEntity<String> addProgram(CreateProgramDTO createProgramDTO) {
        try {
            Program program = convertToEntity(createProgramDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/programs/" + programRepository.save(program).getProgramId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<GetProgramDTO> getProgramById(Long programId) {
        try {
            if (programRepository.findById(programId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(modelMapper.map(programRepository.findById(programId).get(), GetProgramDTO.class));
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<GetProgramDTO>> getAllPrograms() {
        try {
            List<GetProgramDTO> getProgramDTOList = programRepository.findAll().stream()
                    .map(program -> modelMapper.map(program, GetProgramDTO.class)).toList();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(getProgramDTOList);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateProgramById(Long programId, CreateProgramDTO createProgramDTO) {
        try {
            Program program = convertToEntity(createProgramDTO);
            Optional<Program> existingProgram = programRepository.findById(programId);
            if (existingProgram.isPresent()) {
                program.setProgramId(programId);
                Program updatedProgram = programRepository.save(program);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/programs/" + updatedProgram.getProgramId());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteProgramById(Long programId) {
        try {
            programRepository.deleteById(programId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}