package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.EventoRequestDTO;
import cl.dondevamos.backend.dto.response.EventoResponseDTO;
import cl.dondevamos.backend.entity.Categoria;
import cl.dondevamos.backend.entity.Evento;
import cl.dondevamos.backend.entity.Municipio;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.EventoMapper;
import cl.dondevamos.backend.repository.EventoRepository;
import cl.dondevamos.backend.repository.MunicipioRepository;
import cl.dondevamos.backend.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {
    private final EventoRepository repository;
    private final EventoMapper mapper;
    private final MunicipioRepository municipioRepository;
    private final CategoriaRepository categoriaRepository;

    public EventoServiceImpl(EventoRepository repository, EventoMapper mapper, 
                           MunicipioRepository municipioRepository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.municipioRepository = municipioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public EventoResponseDTO crear(EventoRequestDTO evento) {
        Municipio municipio = municipioRepository.findById(evento.getIdMunicipio())
                .orElseThrow(() -> new ResourceNotFoundException("Municipio no encontrado con id: " + evento.getIdMunicipio()));
        
        Evento entity = mapper.toEntity(evento);
        entity.setMunicipio(municipio);
        
        if (evento.getIdCategorias() != null && !evento.getIdCategorias().isEmpty()) {
            Set<Categoria> categorias = new HashSet<>();
            for (Integer idCategoria : evento.getIdCategorias()) {
                Categoria categoria = categoriaRepository.findById(idCategoria)
                        .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con id: " + idCategoria));
                categorias.add(categoria);
            }
            entity.setCategorias(categorias);
        }
        
        Evento saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public EventoResponseDTO obtenerPorId(Integer id) {
        Evento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<EventoResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventoResponseDTO actualizar(Integer id, EventoRequestDTO evento) {
        Evento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con id: " + id));
        
        if (evento.getIdMunicipio() != null && !evento.getIdMunicipio().equals(entity.getMunicipio().getIdMunicipio())) {
            Municipio municipio = municipioRepository.findById(evento.getIdMunicipio())
                    .orElseThrow(() -> new ResourceNotFoundException("Municipio no encontrado con id: " + evento.getIdMunicipio()));
            entity.setMunicipio(municipio);
        }
        
        if (evento.getIdCategorias() != null && !evento.getIdCategorias().isEmpty()) {
            Set<Categoria> categorias = new HashSet<>();
            for (Integer idCategoria : evento.getIdCategorias()) {
                Categoria categoria = categoriaRepository.findById(idCategoria)
                        .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con id: " + idCategoria));
                categorias.add(categoria);
            }
            entity.setCategorias(categorias);
        }
        
        mapper.updateEntity(evento, entity);
        Evento updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        Evento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con id: " + id));
        repository.delete(entity);
    }
}
