package fi.experis.mefit.repositories;

import fi.experis.mefit.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
