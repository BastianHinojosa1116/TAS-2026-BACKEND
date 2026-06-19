package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.UsuarioAppRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioAppResponseDTO;
import cl.dondevamos.backend.entity.UsuarioApp;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.UsuarioAppMapper;
import cl.dondevamos.backend.repository.UsuarioAppRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioAppServiceImpl implements UsuarioAppService {
    private final UsuarioAppRepository repository;
    private final UsuarioAppMapper mapper;

    public UsuarioAppServiceImpl(UsuarioAppRepository repository, UsuarioAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UsuarioAppResponseDTO crear(UsuarioAppRequestDTO usuario) {
        UsuarioApp entity = mapper.toEntity(usuario);
        UsuarioApp saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public UsuarioAppResponseDTO obtenerPorId(Integer id) {
        UsuarioApp entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<UsuarioAppResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioAppResponseDTO actualizar(Integer id, UsuarioAppRequestDTO usuario) {
        UsuarioApp entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        mapper.updateEntity(usuario, entity);
        UsuarioApp updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        UsuarioApp entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        repository.delete(entity);
    }
}
