package fi.experis.mefit.repositories;

import fi.experis.mefit.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}
