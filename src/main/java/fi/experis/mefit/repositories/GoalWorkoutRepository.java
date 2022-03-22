package fi.experis.mefit.repositories;

import fi.experis.mefit.models.entities.GoalWorkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalWorkoutRepository extends JpaRepository<GoalWorkout, Long> {
}
