package tech.souleymane.gest_project_backend.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.souleymane.gest_project_backend.models.Project;
import tech.souleymane.gest_project_backend.models.Spot;
import tech.souleymane.gest_project_backend.models.Team;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpotDto {
    private Integer id;
    private String name;
    private String description;
    private Date starDate;
    private Date endDate;
    private Date createdDate;
    private Integer project_id;
    private Integer team_id;

    public static SpotDto toDto(Spot spot) {
        return SpotDto.builder()
                .id(spot.getId())
                .name(spot.getName())
                .description(spot.getDescription())
                .starDate(spot.getStarDate())
                .endDate(spot.getEndDate())
                .createdDate(spot.getCreatedDate())
                .project_id(spot.getProject().getId())
                .team_id(spot.getTeam().getId())
                .build();
    }

    public static Spot toEntity(SpotDto spot) {
        return Spot.builder()
                .id(spot.getId())
                .name(spot.getName())
                .description(spot.getDescription())
                .starDate(spot.getStarDate())
                .endDate(spot.getEndDate())
                .createdDate(spot.getCreatedDate())
                .project(Project.builder()
                        .id(spot.getProject_id())
                        .build())
                .team(Team.builder()
                        .id(spot.getTeam_id())
                        .build())
                .build();
    }
}
