package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.AsistenciaEventoRequestDTO;
import cl.dondevamos.backend.dto.response.AsistenciaEventoResponseDTO;
import cl.dondevamos.backend.entity.AsistenciaEvento;
import cl.dondevamos.backend.entity.Evento;
import cl.dondevamos.backend.entity.UsuarioApp;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.AsistenciaEventoMapper;
import cl.dondevamos.backend.repository.AsistenciaEventoRepository;
import cl.dondevamos.backend.repository.UsuarioAppRepository;
import cl.dondevamos.backend.repository.EventoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsistenciaEventoServiceImpl implements AsistenciaEventoService {
    private final AsistenciaEventoRepository repository;
    private final AsistenciaEventoMapper mapper;
    private final UsuarioAppRepository usuarioAppRepository;
    private final EventoRepository eventoRepository;

    public AsistenciaEventoServiceImpl(AsistenciaEventoRepository repository, AsistenciaEventoMapper mapper, 
                                     UsuarioAppRepository usuarioAppRepository, EventoRepository eventoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.usuarioAppRepository = usuarioAppRepository;
        this.eventoRepository = eventoRepository;
    }

    @Override
    public AsistenciaEventoResponseDTO crear(AsistenciaEventoRequestDTO asistencia) {
        UsuarioApp usuarioApp = usuarioAppRepository.findById(asistencia.getIdUsuarioApp())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + asistencia.getIdUsuarioApp()));
        Evento evento = eventoRepository.findById(asistencia.getIdEvento())
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con id: " + asistencia.getIdEvento()));
        
        AsistenciaEvento entity = mapper.toEntity(asistencia);
        entity.setUsuarioApp(usuarioApp);
        entity.setEvento(evento);
        AsistenciaEvento saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public AsistenciaEventoResponseDTO obtenerPorId(Integer id) {
        AsistenciaEvento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<AsistenciaEventoResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsistenciaEventoResponseDTO actualizar(Integer id, AsistenciaEventoRequestDTO asistencia) {
        AsistenciaEvento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con id: " + id));
        
        if (asistencia.getIdUsuarioApp() != null && !asistencia.getIdUsuarioApp().equals(entity.getUsuarioApp().getIdUsuarioApp())) {
            UsuarioApp usuarioApp = usuarioAppRepository.findById(asistencia.getIdUsuarioApp())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + asistencia.getIdUsuarioApp()));
            entity.setUsuarioApp(usuarioApp);
        }
        
        if (asistencia.getIdEvento() != null && !asistencia.getIdEvento().equals(entity.getEvento().getIdEvento())) {
            Evento evento = eventoRepository.findById(asistencia.getIdEvento())
                    .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con id: " + asistencia.getIdEvento()));
            entity.setEvento(evento);
        }
        
        mapper.updateEntity(asistencia, entity);
        AsistenciaEvento updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        AsistenciaEvento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con id: " + id));
        repository.delete(entity);
    }
}
