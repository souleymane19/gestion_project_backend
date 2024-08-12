package tech.souleymane.gest_project_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.souleymane.gest_project_backend.dtos.TeamDto;
import tech.souleymane.gest_project_backend.dtos.UserDto;
import tech.souleymane.gest_project_backend.dtos.UserInTeamRequest;
import tech.souleymane.gest_project_backend.services.TeamService;
import tech.souleymane.gest_project_backend.services.UserService;

import java.util.List;

@RestController
@RequestMapping("team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/")
    public ResponseEntity<String>  addTeam(@RequestBody TeamDto teamDto) {
        teamService.save(teamDto);
        return ResponseEntity.accepted().body("added team successfully");
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateTeam(@PathVariable Integer id, @RequestBody TeamDto teamDto) {
        teamDto.setId(id);
        teamService.save(teamDto);
        return ResponseEntity.accepted().body("updated Team successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Integer id) {
        TeamDto newTeam = new TeamDto();
        newTeam.setId(id);
        teamService.delete(newTeam);

        return ResponseEntity.accepted().body("deleted Team successfully");
    }
    @GetMapping("/")
    public ResponseEntity<List<TeamDto>> getAllTeam() {
        return ResponseEntity.accepted().body(teamService.getAll());
    }
    @PostMapping("/user")
    public ResponseEntity<String> addUserInTeam(@RequestBody UserInTeamRequest userInTeamRequest) {
         teamService.addUserInTeam(userInTeamRequest);
        return ResponseEntity.accepted().body("user save in team successfully");
    }
    @DeleteMapping("/user")
    public ResponseEntity<String> removeUserInTeam(@RequestBody UserInTeamRequest userInTeamRequest) {
        teamService.deleteUserFromTeam(userInTeamRequest);
        return ResponseEntity.accepted().body("user remove in team successfully");
    }


}
