package tech.souleymane.gest_project_backend.services.impls;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.souleymane.gest_project_backend.dtos.ProjectDto;
import tech.souleymane.gest_project_backend.models.Project;
import tech.souleymane.gest_project_backend.repositorys.ProjectRepository;
import tech.souleymane.gest_project_backend.services.ProjectService;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    @Override
    public void save(ProjectDto projectDto) {
        projectRepository.save(ProjectDto.fromDto(projectDto));
    }

    @Override
    public void delete(ProjectDto projectDto) {
        projectRepository.delete(ProjectDto.fromDto(projectDto));

    }

    @Override
    public void update(ProjectDto projectDto) {
        projectRepository.save(ProjectDto.fromDto(projectDto));

    }

    @Override
    public List<ProjectDto> getAll() {
        return projectRepository.findAll().stream().map(ProjectDto::toDto).collect(Collectors.toList());
    }

    @Override
    public ProjectDto getById(int id) {
        return projectRepository.findById(id).map(ProjectDto::toDto).orElse(null);
    }
}
