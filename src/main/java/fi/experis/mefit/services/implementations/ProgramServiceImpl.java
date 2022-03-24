package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.postDtos.ProgramDTO;
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

    private Program convertToEntity(ProgramDTO programDTO) {
        Program program = modelMapper.map(programDTO, Program.class);
        if (program.getWorkouts() != null) program.setWorkouts(workoutRepository.findAllById(program.getWorkouts().stream()
                .map(Workout::getWorkoutId).collect(Collectors.toList())));
        return program;
    }

    @Override
    public ResponseEntity<String> addProgram(ProgramDTO programDTO) {
        try {
            Program program = convertToEntity(programDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/programs/" + programRepository.save(program).getProgramId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Program> getProgramById(Long programId) {
        try {
            if (programRepository.findById(programId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(programRepository.findById(programId).get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Program>> getAllPrograms() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(programRepository.findAll());
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateProgramById(Long programId, ProgramDTO programDTO) {
        try {
            Program program = convertToEntity(programDTO);
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
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}