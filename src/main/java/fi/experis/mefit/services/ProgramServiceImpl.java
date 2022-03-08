package fi.experis.mefit.services;

import fi.experis.mefit.models.Program;
import fi.experis.mefit.repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    private ProgramRepository programRepository;
    @Override
    public Program addProgram(Program program) {
        return programRepository.save(program);
    }
    @Override
    public Program getProgramById(Long programId) {
        return programRepository.findById(programId).get();
    }
    @Override
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }
    @Override
    public void updateProgramById(Long programId, Program program) {
        if (programRepository.findById(programId).isPresent()) {
            programRepository.save(program);
        }
    }
    @Override
    public void deleteProgramById(Long programId) {
        try {
            programRepository.deleteById(programId);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}