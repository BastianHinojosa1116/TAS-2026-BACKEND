package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.ComunaRequestDTO;
import cl.dondevamos.backend.dto.response.ComunaResponseDTO;
import cl.dondevamos.backend.entity.Comuna;
import cl.dondevamos.backend.entity.Provincia;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.ComunaMapper;
import cl.dondevamos.backend.repository.ComunaRepository;
import cl.dondevamos.backend.repository.ProvinciaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComunaServiceImpl implements ComunaService {
    private final ComunaRepository repository;
    private final ComunaMapper mapper;
    private final ProvinciaRepository provinciaRepository;

    public ComunaServiceImpl(ComunaRepository repository, ComunaMapper mapper, ProvinciaRepository provinciaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.provinciaRepository = provinciaRepository;
    }

    @Override
    public ComunaResponseDTO crear(ComunaRequestDTO comuna) {
        Provincia provincia = provinciaRepository.findById(comuna.getIdProvincia())
                .orElseThrow(() -> new ResourceNotFoundException("Provincia no encontrada con id: " + comuna.getIdProvincia()));
        Comuna entity = mapper.toEntity(comuna);
        entity.setProvincia(provincia);
        Comuna saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public ComunaResponseDTO obtenerPorId(Integer id) {
        Comuna entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comuna no encontrada con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<ComunaResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ComunaResponseDTO actualizar(Integer id, ComunaRequestDTO comuna) {
        Comuna entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comuna no encontrada con id: " + id));
        
        if (comuna.getIdProvincia() != null && !comuna.getIdProvincia().equals(entity.getProvincia().getIdProvincia())) {
            Provincia provincia = provinciaRepository.findById(comuna.getIdProvincia())
                    .orElseThrow(() -> new ResourceNotFoundException("Provincia no encontrada con id: " + comuna.getIdProvincia()));
            entity.setProvincia(provincia);
        }
        
        mapper.updateEntity(comuna, entity);
        Comuna updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        Comuna entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comuna no encontrada con id: " + id));
        repository.delete(entity);
    }
}
