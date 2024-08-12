package tech.souleymane.gest_project_backend.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.souleymane.gest_project_backend.models.Project;
import tech.souleymane.gest_project_backend.models.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
