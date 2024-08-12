package tech.souleymane.gest_project_backend.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.souleymane.gest_project_backend.models.Team;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private Integer id;
    private String name;


    public static TeamDto toDto(Team team) {
      return   TeamDto.builder().id(team.getId())
                .name(team.getName())
                .build();
    }
    public static Team toEntity(TeamDto teamDto) {
     return Team.builder()
             .id(teamDto.getId())
             .name(teamDto.getName())
             .build();
    }
}
