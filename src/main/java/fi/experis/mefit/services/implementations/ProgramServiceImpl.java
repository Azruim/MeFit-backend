package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.entities.Program;
import fi.experis.mefit.repositories.ProgramRepository;
import fi.experis.mefit.services.interfaces.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public ResponseEntity<String> addProgram(Program program) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("/api/v1/programs/" + programRepository.save(program).getProgramId());
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> updateProgramById(Long programId, Map<Object, Object> fields) {
        try {
            Optional<Program> program = programRepository.findById(programId);
            if (program.isPresent()) {
                fields.forEach((Object key, Object value) -> {
                    Field field = ReflectionUtils.findField(Program.class, (String) key);
                    assert field != null;
                    field.trySetAccessible();
                    ReflectionUtils.setField(field, program.get(), value);
                });
                Program updatedProgram = programRepository.save(program.get());
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/programs/" + updatedProgram.getProgramId());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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