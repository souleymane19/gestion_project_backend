package tech.souleymane.gest_project_backend.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.souleymane.gest_project_backend.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
