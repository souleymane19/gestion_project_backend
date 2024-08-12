package tech.souleymane.gest_project_backend.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.souleymane.gest_project_backend.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
