package fi.experis.mefit.repositories;

import fi.experis.mefit.models.GoalWorkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalWorkoutRepository extends JpaRepository<GoalWorkout, Long> {
}
