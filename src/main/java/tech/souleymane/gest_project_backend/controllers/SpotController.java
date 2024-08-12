package tech.souleymane.gest_project_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.souleymane.gest_project_backend.dtos.SpotDto;
import tech.souleymane.gest_project_backend.dtos.UserDto;
import tech.souleymane.gest_project_backend.services.SpotService;
import tech.souleymane.gest_project_backend.services.UserService;

import java.util.List;

@RestController
@RequestMapping("spot")
@RequiredArgsConstructor
public class SpotController {
    private final SpotService spotService;

    @PostMapping("/")
    public ResponseEntity<String>  addSpot(@RequestBody SpotDto spotDto) {
        spotService.save(spotDto);
        return ResponseEntity.accepted().body("added Spot successfully");
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateSpot(@PathVariable Integer id, @RequestBody SpotDto spotDto) {
        spotDto.setId(id);
        spotService.save(spotDto);
        return ResponseEntity.accepted().body("updated Spot successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpot(@PathVariable Integer id) {

        SpotDto newSpot = new SpotDto();
        newSpot.setId(id);
        spotService.delete(newSpot);

        return ResponseEntity.accepted().body("deleted user successfully");
    }
    @GetMapping("/")
    public ResponseEntity<List<SpotDto>> getAllSpot() {
        return ResponseEntity.accepted().body(spotService.getAll());
    }


}
