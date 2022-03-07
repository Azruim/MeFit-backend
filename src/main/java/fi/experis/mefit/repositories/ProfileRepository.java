package fi.experis.mefit.repositories;

import fi.experis.mefit.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
