package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.MunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.MunicipioResponseDTO;
import cl.dondevamos.backend.entity.Comuna;
import cl.dondevamos.backend.entity.Municipio;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.MunicipioMapper;
import cl.dondevamos.backend.repository.MunicipioRepository;
import cl.dondevamos.backend.repository.ComunaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipioServiceImpl implements MunicipioService {
    private final MunicipioRepository repository;
    private final MunicipioMapper mapper;
    private final ComunaRepository comunaRepository;

    public MunicipioServiceImpl(MunicipioRepository repository, MunicipioMapper mapper, ComunaRepository comunaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.comunaRepository = comunaRepository;
    }

    @Override
    public MunicipioResponseDTO crear(MunicipioRequestDTO municipio) {
        Comuna comuna = comunaRepository.findById(municipio.getIdComuna())
                .orElseThrow(() -> new ResourceNotFoundException("Comuna no encontrada con id: " + municipio.getIdComuna()));
        Municipio entity = mapper.toEntity(municipio);
        entity.setComuna(comuna);
        Municipio saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public MunicipioResponseDTO obtenerPorId(Integer id) {
        Municipio entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Municipio no encontrado con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<MunicipioResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MunicipioResponseDTO actualizar(Integer id, MunicipioRequestDTO municipio) {
        Municipio entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Municipio no encontrado con id: " + id));
        
        if (municipio.getIdComuna() != null && !municipio.getIdComuna().equals(entity.getComuna().getIdComuna())) {
            Comuna comuna = comunaRepository.findById(municipio.getIdComuna())
                    .orElseThrow(() -> new ResourceNotFoundException("Comuna no encontrada con id: " + municipio.getIdComuna()));
            entity.setComuna(comuna);
        }
        
        mapper.updateEntity(municipio, entity);
        Municipio updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        Municipio entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Municipio no encontrado con id: " + id));
        repository.delete(entity);
    }
}
