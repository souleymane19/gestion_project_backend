package tech.souleymane.gest_project_backend.services;

import tech.souleymane.gest_project_backend.dtos.UserDto;

import java.util.List;

public interface UserService extends AbstractService<UserDto> {

    List<UserDto> getUsersInTeam(Integer team_id);
}
