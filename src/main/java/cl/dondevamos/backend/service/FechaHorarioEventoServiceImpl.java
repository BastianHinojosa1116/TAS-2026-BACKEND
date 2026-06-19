package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.FechaHorarioEventoRequestDTO;
import cl.dondevamos.backend.dto.response.FechaHorarioEventoResponseDTO;
import cl.dondevamos.backend.entity.Evento;
import cl.dondevamos.backend.entity.FechaHorarioEvento;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.FechaHorarioEventoMapper;
import cl.dondevamos.backend.repository.FechaHorarioEventoRepository;
import cl.dondevamos.backend.repository.EventoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FechaHorarioEventoServiceImpl implements FechaHorarioEventoService {
    private final FechaHorarioEventoRepository repository;
    private final FechaHorarioEventoMapper mapper;
    private final EventoRepository eventoRepository;

    public FechaHorarioEventoServiceImpl(FechaHorarioEventoRepository repository, FechaHorarioEventoMapper mapper, 
                                       EventoRepository eventoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.eventoRepository = eventoRepository;
    }

    @Override
    public FechaHorarioEventoResponseDTO crear(FechaHorarioEventoRequestDTO fechaHorario) {
        Evento evento = eventoRepository.findById(fechaHorario.getIdEvento())
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con id: " + fechaHorario.getIdEvento()));
        
        FechaHorarioEvento entity = mapper.toEntity(fechaHorario);
        entity.setEvento(evento);
        FechaHorarioEvento saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public FechaHorarioEventoResponseDTO obtenerPorId(Integer id) {
        FechaHorarioEvento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fecha/Horario evento no encontrado con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<FechaHorarioEventoResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FechaHorarioEventoResponseDTO actualizar(Integer id, FechaHorarioEventoRequestDTO fechaHorario) {
        FechaHorarioEvento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fecha/Horario evento no encontrado con id: " + id));
        
        if (fechaHorario.getIdEvento() != null && !fechaHorario.getIdEvento().equals(entity.getEvento().getIdEvento())) {
            Evento evento = eventoRepository.findById(fechaHorario.getIdEvento())
                    .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con id: " + fechaHorario.getIdEvento()));
            entity.setEvento(evento);
        }
        
        mapper.updateEntity(fechaHorario, entity);
        FechaHorarioEvento updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        FechaHorarioEvento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fecha/Horario evento no encontrado con id: " + id));
        repository.delete(entity);
    }
}
