package tech.souleymane.gest_project_backend.services.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.souleymane.gest_project_backend.dtos.TeamDto;
import tech.souleymane.gest_project_backend.dtos.UserDto;
import tech.souleymane.gest_project_backend.dtos.UserInTeamRequest;
import tech.souleymane.gest_project_backend.models.Team;
import tech.souleymane.gest_project_backend.models.User;
import tech.souleymane.gest_project_backend.repositorys.TeamRepository;
import tech.souleymane.gest_project_backend.repositorys.UserRepository;
import tech.souleymane.gest_project_backend.services.TeamService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;
    private UserRepository userRepository;
    @Override
    public void save(TeamDto teamDto) {
       teamRepository.save(TeamDto.toEntity(teamDto));
    }

    @Override
    public void delete(TeamDto teamDto) {
        teamRepository.delete(TeamDto.toEntity(teamDto));

    }

    @Override
    public void update(TeamDto teamDto) {
        teamRepository.save(TeamDto.toEntity(teamDto));

    }

    @Override
    public List<TeamDto> getAll() {
        return teamRepository.findAll().stream().map(TeamDto::toDto).collect(Collectors.toList());
    }

    @Override
    public TeamDto getById(int id) {
        return teamRepository.findById(id).map(TeamDto::toDto).orElse(null);
    }

    @Override
    public void addUserInTeam(UserInTeamRequest userInTeamRequest) {

        // Retrieve existing entities
        User userById = userRepository.findById(userInTeamRequest.userId()).orElse(null);
        Team teamById = teamRepository.findById(userInTeamRequest.teamId()).orElse(null);

        if (userById != null && teamById != null) {
            // Add the team to the user and vice versa
            userById.getTeam().add(teamById);
            teamById.getUsers().add(userById);
            // Save the updated entities
            userRepository.save(userById);
            teamRepository.save(teamById);
        } else {
            // Handle cases where entities are not found
            throw new RuntimeException("User or Team not found");
        }

    }

    @Override
    public void deleteUserFromTeam(UserInTeamRequest userInTeamRequest) {
        User userById = userRepository.findById(userInTeamRequest.userId()).orElse(null);
        Team teamById = teamRepository.findById(userInTeamRequest.teamId()).orElse(null);

        if (userById != null && teamById != null) {
            userById.getTeam().remove(teamById);
            teamById.getUsers().remove(userById);
            userRepository.save(userById);
            teamRepository.save(teamById);
        }
    }


}
