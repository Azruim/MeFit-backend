package fi.experis.mefit.repositories;

import fi.experis.mefit.models.entities.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<Set, Long> {
}
