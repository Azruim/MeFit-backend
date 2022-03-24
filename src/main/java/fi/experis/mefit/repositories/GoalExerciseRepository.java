package fi.experis.mefit.repositories;

import fi.experis.mefit.models.entities.GoalExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalExerciseRepository extends JpaRepository<GoalExercise, Long> {
}
