package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Program;
import fi.experis.mefit.repositories.ProgramRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/programs")
public class ProgramController {

    ProgramRepository programRepository;

    @GetMapping("")
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }
}
