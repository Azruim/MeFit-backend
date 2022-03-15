package fi.experis.mefit.services;

import fi.experis.mefit.models.Program;
import fi.experis.mefit.repositories.ProgramRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public ResponseEntity<Program> addProgram(Program program) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(programRepository.save(program));
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
    public ResponseEntity<Program> updateProgramById(Long programId, Program program) {
        try {
            if (programRepository.existsById(programId)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(programRepository.save(program));
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