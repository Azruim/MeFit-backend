package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.programDtos.get.ProgramGetDTO;
import fi.experis.mefit.models.dtos.programDtos.post.ProgramPostDTO;
import fi.experis.mefit.models.entities.Program;
import fi.experis.mefit.models.entities.Workout;
import fi.experis.mefit.repositories.ProgramRepository;
import fi.experis.mefit.repositories.WorkoutRepository;
import fi.experis.mefit.services.interfaces.ProgramService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final WorkoutRepository workoutRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public ProgramServiceImpl(ProgramRepository programRepository, WorkoutRepository workoutRepository) {
        this.programRepository = programRepository;
        this.workoutRepository = workoutRepository;
    }

    private Program convertToEntity(ProgramPostDTO programPostDTO) {
        Program program = modelMapper.map(programPostDTO, Program.class);
        if (program.getWorkouts() != null) program.setWorkouts(workoutRepository.findAllById(program.getWorkouts().stream()
                .map(Workout::getWorkoutId).collect(Collectors.toList())));
        return program;
    }

    @Override
    public ResponseEntity<String> addProgram(ProgramPostDTO programPostDTO) {
        try {
            Program program = convertToEntity(programPostDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/programs/" + programRepository.save(program).getProgramId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ProgramGetDTO> getProgramById(Long programId) {
        try {
            if (programRepository.findById(programId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(modelMapper.map(programRepository.findById(programId).get(), ProgramGetDTO.class));
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<ProgramGetDTO>> getAllPrograms() {
        try {
            List<ProgramGetDTO> programGetDTOList = programRepository.findAll().stream()
                    .map(program -> modelMapper.map(program, ProgramGetDTO.class)).toList();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(programGetDTOList);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateProgramById(Long programId, ProgramPostDTO programPostDTO) {
        try {
            Program program = convertToEntity(programPostDTO);
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