package tech.souleymane.gest_project_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.souleymane.gest_project_backend.dtos.ProjectDto;
import tech.souleymane.gest_project_backend.dtos.SpotDto;
import tech.souleymane.gest_project_backend.dtos.TeamDto;
import tech.souleymane.gest_project_backend.dtos.UserDto;
import tech.souleymane.gest_project_backend.models.User;
import tech.souleymane.gest_project_backend.repositorys.UserRepository;
import tech.souleymane.gest_project_backend.services.ProjectService;
import tech.souleymane.gest_project_backend.services.SpotService;
import tech.souleymane.gest_project_backend.services.TeamService;
import tech.souleymane.gest_project_backend.services.UserService;

@SpringBootApplication
public class GestProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestProjectBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(ProjectService projectService,
								   SpotService spotService,
								   TeamService teamService,
								   UserService userService) {
		return args -> {
			// Création des utilisateurs
			for (int i = 1; i < 10; i++) {
				UserDto user = UserDto.builder()
						.name("user" + i)
						.email("user" + i + "@gmail.com")
						.password("password" + i)
						.build();
				userService.save(user);
			}

			// Création des projets
			for (int i = 1; i < 5; i++) {
				ProjectDto project = ProjectDto.builder()
						.name("project" + i)
						.description("description" + i)
						.build();
				projectService.save(project);
			}

			// Création des équipes
			for (int i = 1; i < 5; i++) {
				TeamDto team = TeamDto.builder()
						.name("team" + i)
						.build();
				teamService.save(team);
			}

			// Création des spots
			for (int i = 1; i < 10; i++) {
				TeamDto team = teamService.getById(i % 4 + 1); // Utiliser des IDs valides pour Team
				ProjectDto project = projectService.getById(i % 4 + 1); // Utiliser des IDs valides pour Project

				SpotDto spot = SpotDto.builder()
						.name("spot" + i)
						.description("description" + i)
						.project_id(project.getId()) // Assurez-vous que le projet est valide
						.team_id(team.getId()) // Assurez-vous que l'équipe est valide
						.build();
				spotService.save(spot);
			}


		};
	}

}
