package fi.experis.mefit.services;

import fi.experis.mefit.models.Program;

import java.util.List;

public interface ProgramService {
    Program addProgram(Program program);
    Program getProgramById(Long programId);
    void updateProgramById(Long programId, Program program);
    void deleteProgramById(Long programId);
    List<Program> getAllPrograms();
}
