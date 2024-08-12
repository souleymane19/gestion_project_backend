package tech.souleymane.gest_project_backend.services.impls;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.souleymane.gest_project_backend.dtos.SpotDto;
import tech.souleymane.gest_project_backend.repositorys.SpotRepository;
import tech.souleymane.gest_project_backend.services.SpotService;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class SpotServiceImpl implements SpotService {
    private SpotRepository spotRepository;

    @Override
    public void save(SpotDto spotDto) {
        spotRepository.save(SpotDto.toEntity(spotDto));
    }

    @Override
    public void delete(SpotDto spotDto) {
        spotRepository.delete(SpotDto.toEntity(spotDto));
    }

    @Override
    public void update(SpotDto spotDto) {
        spotRepository.save(SpotDto.toEntity(spotDto));
    }

    @Override
    public List<SpotDto> getAll() {
        return spotRepository.findAll().stream().map(SpotDto::toDto).collect(Collectors.toList());
    }

    @Override
    public SpotDto getById(int id) {
        return spotRepository.findById(id).map(SpotDto::toDto).orElse(null);
    }
}
