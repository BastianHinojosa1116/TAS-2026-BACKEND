package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.ProvinciaRequestDTO;
import cl.dondevamos.backend.dto.response.ProvinciaResponseDTO;
import cl.dondevamos.backend.entity.Provincia;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.ProvinciaMapper;
import cl.dondevamos.backend.repository.ProvinciaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {
    private final ProvinciaRepository repository;
    private final ProvinciaMapper mapper;

    public ProvinciaServiceImpl(ProvinciaRepository repository, ProvinciaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProvinciaResponseDTO crear(ProvinciaRequestDTO provincia) {
        Provincia entity = mapper.toEntity(provincia);
        Provincia saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public ProvinciaResponseDTO obtenerPorId(Integer id) {
        Provincia entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provincia no encontrada con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<ProvinciaResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProvinciaResponseDTO actualizar(Integer id, ProvinciaRequestDTO provincia) {
        Provincia entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provincia no encontrada con id: " + id));
        mapper.updateEntity(provincia, entity);
        Provincia updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        Provincia entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provincia no encontrada con id: " + id));
        repository.delete(entity);
    }
}
