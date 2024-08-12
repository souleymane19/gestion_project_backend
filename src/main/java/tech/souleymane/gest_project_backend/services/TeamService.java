package tech.souleymane.gest_project_backend.services;

import tech.souleymane.gest_project_backend.dtos.TeamDto;
import tech.souleymane.gest_project_backend.dtos.UserDto;
import tech.souleymane.gest_project_backend.dtos.UserInTeamRequest;

import java.util.List;

public interface TeamService extends AbstractService<TeamDto> {

    void addUserInTeam(UserInTeamRequest userInTeamRequest);
    void deleteUserFromTeam(UserInTeamRequest userInTeamRequest);
}
