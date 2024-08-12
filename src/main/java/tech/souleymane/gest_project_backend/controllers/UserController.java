package tech.souleymane.gest_project_backend.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.souleymane.gest_project_backend.dtos.UserDto;
import tech.souleymane.gest_project_backend.models.User;
import tech.souleymane.gest_project_backend.services.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<String>  addUser(@RequestBody UserDto user) {
        userService.save(user);
        return ResponseEntity.accepted().body("added user successfully");
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserDto user) {
        user.setId(id);
        userService.save(user);
        return ResponseEntity.accepted().body("updated user successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        UserDto newUser = new UserDto();
        newUser.setId(id);
        userService.delete(newUser);

        return ResponseEntity.accepted().body("deleted user successfully");
    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.accepted().body(userService.getAll());
    }
    @GetMapping("/{team_id}")
    public ResponseEntity<List<UserDto>> getUsersInTeam(@PathVariable Integer team_id) {
        return ResponseEntity.accepted().body(userService.getUsersInTeam(team_id));
    }



}
