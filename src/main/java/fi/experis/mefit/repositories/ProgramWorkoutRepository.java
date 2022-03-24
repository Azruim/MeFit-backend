package fi.experis.mefit.repositories;

import fi.experis.mefit.models.entities.ProgramWorkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramWorkoutRepository extends JpaRepository<ProgramWorkout, Long> {
}
