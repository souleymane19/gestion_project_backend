package tech.souleymane.gest_project_backend.services.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.souleymane.gest_project_backend.dtos.UserDto;
import tech.souleymane.gest_project_backend.models.User;
import tech.souleymane.gest_project_backend.repositorys.TeamRepository;
import tech.souleymane.gest_project_backend.repositorys.UserRepository;
import tech.souleymane.gest_project_backend.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private TeamRepository teamRepository;
    @Override
    public void save(UserDto userDto) {
        User entity = UserDto.toEntity(userDto);
        userRepository.save(entity);
    }

    @Override
    public void delete(UserDto userDto) {
      User entity = UserDto.toEntity(userDto);
        Optional<User> byId = userRepository.findById(entity.getId());
        byId.ifPresent(user -> userRepository.delete(user));
        throw new EntityNotFoundException("User with id " + entity.getId() + " not found");
    }

    @Override
    public void update(UserDto userDto) {
        User entity = UserDto.toEntity(userDto);
        Optional<User> byId = userRepository.findById(entity.getId());
        byId.ifPresent(user -> userRepository.save(user));
        throw new EntityNotFoundException("User with id " + entity.getId() + " not found");
    }

    @Override
    public List<UserDto> getAll() {

        return userRepository.findAll().stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public UserDto getById(int id) {

        return userRepository.findById(id).map(UserDto::toDto).orElse(null);
    }

    @Override
    public List<UserDto> getUsersInTeam(Integer team_id) {
        return teamRepository.findById(team_id).orElseThrow(()-> new EntityNotFoundException("Team not found"))
                .getUsers().stream().map(UserDto::toDto).collect(Collectors.toList());
    }


}
