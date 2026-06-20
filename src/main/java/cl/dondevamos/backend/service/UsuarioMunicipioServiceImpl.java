package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.UsuarioMunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioMunicipioResponseDTO;
import cl.dondevamos.backend.entity.Municipio;
import cl.dondevamos.backend.entity.Rol;
import cl.dondevamos.backend.entity.UsuarioMunicipio;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.UsuarioMunicipioMapper;
import cl.dondevamos.backend.repository.UsuarioMunicipioRepository;
import cl.dondevamos.backend.repository.RolRepository;
import cl.dondevamos.backend.repository.MunicipioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioMunicipioServiceImpl implements UsuarioMunicipioService {
    private final UsuarioMunicipioRepository repository;
    private final UsuarioMunicipioMapper mapper;
    private final RolRepository rolRepository;
    private final MunicipioRepository municipioRepository;

    public UsuarioMunicipioServiceImpl(UsuarioMunicipioRepository repository, UsuarioMunicipioMapper mapper, 
                                     RolRepository rolRepository, MunicipioRepository municipioRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.rolRepository = rolRepository;
        this.municipioRepository = municipioRepository;
    }

    @Override
    public UsuarioMunicipioResponseDTO crear(UsuarioMunicipioRequestDTO usuario) {
        Rol rol = rolRepository.findById(usuario.getIdRol())
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + usuario.getIdRol()));
        Municipio municipio = municipioRepository.findById(usuario.getIdMunicipio())
                .orElseThrow(() -> new ResourceNotFoundException("Municipio no encontrado con id: " + usuario.getIdMunicipio()));
        
        UsuarioMunicipio entity = mapper.toEntity(usuario);
        entity.setRol(rol);
        entity.setMunicipio(municipio);
        entity.setFechaCreacion(LocalDateTime.now());
        UsuarioMunicipio saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public UsuarioMunicipioResponseDTO obtenerPorId(Integer id) {
        UsuarioMunicipio entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario municipio no encontrado con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<UsuarioMunicipioResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioMunicipioResponseDTO actualizar(Integer id, UsuarioMunicipioRequestDTO usuario) {
        UsuarioMunicipio entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario municipio no encontrado con id: " + id));
        
        if (usuario.getIdRol() != null && !usuario.getIdRol().equals(entity.getRol().getIdRol())) {
            Rol rol = rolRepository.findById(usuario.getIdRol())
                    .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + usuario.getIdRol()));
            entity.setRol(rol);
        }
        
        if (usuario.getIdMunicipio() != null && !usuario.getIdMunicipio().equals(entity.getMunicipio().getIdMunicipio())) {
            Municipio municipio = municipioRepository.findById(usuario.getIdMunicipio())
                    .orElseThrow(() -> new ResourceNotFoundException("Municipio no encontrado con id: " + usuario.getIdMunicipio()));
            entity.setMunicipio(municipio);
        }
        
        mapper.updateEntity(usuario, entity);
        UsuarioMunicipio updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        UsuarioMunicipio entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario municipio no encontrado con id: " + id));
        repository.delete(entity);
    }
}
