package fi.experis.mefit.repositories;

import fi.experis.mefit.models.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
