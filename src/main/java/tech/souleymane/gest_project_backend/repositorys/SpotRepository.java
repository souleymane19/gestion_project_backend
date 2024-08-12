package tech.souleymane.gest_project_backend.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.souleymane.gest_project_backend.models.Spot;

public interface SpotRepository extends JpaRepository<Spot, Integer> {
}
