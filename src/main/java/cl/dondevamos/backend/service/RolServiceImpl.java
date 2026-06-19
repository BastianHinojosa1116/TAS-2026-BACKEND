package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.RolRequestDTO;
import cl.dondevamos.backend.dto.response.RolResponseDTO;
import cl.dondevamos.backend.entity.Rol;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.RolMapper;
import cl.dondevamos.backend.repository.RolRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository repository;
    private final RolMapper mapper;

    public RolServiceImpl(RolRepository repository, RolMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RolResponseDTO crear(RolRequestDTO rol) {
        Rol entity = mapper.toEntity(rol);
        Rol saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public RolResponseDTO obtenerPorId(Integer id) {
        Rol entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<RolResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RolResponseDTO actualizar(Integer id, RolRequestDTO rol) {
        Rol entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        mapper.updateEntity(rol, entity);
        Rol updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        Rol entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        repository.delete(entity);
    }
}
