package fi.experis.mefit.repositories;

import fi.experis.mefit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
