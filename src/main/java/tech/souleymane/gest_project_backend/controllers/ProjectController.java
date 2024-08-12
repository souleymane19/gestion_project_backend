package tech.souleymane.gest_project_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.souleymane.gest_project_backend.dtos.ProjectDto;
import tech.souleymane.gest_project_backend.dtos.UserDto;
import tech.souleymane.gest_project_backend.services.ProjectService;
import tech.souleymane.gest_project_backend.services.UserService;

import java.util.List;

@RestController
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/")
    public ResponseEntity<String>  addProject(@RequestBody ProjectDto projectDto) {
        projectService.save(projectDto);
        return ResponseEntity.accepted().body("added Project successfully");
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateProject(@PathVariable Integer id, @RequestBody ProjectDto projectDto) {
        projectDto.setId(id);
        projectService.save(projectDto);
        return ResponseEntity.accepted().body("updated Project successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer id) {
        ProjectDto newProject = new ProjectDto();
        newProject.setId(id);
        projectService.delete(newProject);

        return ResponseEntity.accepted().body("deleted user successfully");
    }
    @GetMapping("/")
    public ResponseEntity<List<ProjectDto>> getAllProject() {
        return ResponseEntity.accepted().body(projectService.getAll());
    }


}
