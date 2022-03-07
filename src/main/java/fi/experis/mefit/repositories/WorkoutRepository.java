package fi.experis.mefit.repositories;

import fi.experis.mefit.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
