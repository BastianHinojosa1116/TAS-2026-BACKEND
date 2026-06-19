package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.ComentarioRequestDTO;
import cl.dondevamos.backend.dto.response.ComentarioResponseDTO;
import cl.dondevamos.backend.entity.Comentario;
import cl.dondevamos.backend.entity.Evento;
import cl.dondevamos.backend.entity.UsuarioApp;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.ComentarioMapper;
import cl.dondevamos.backend.repository.ComentarioRepository;
import cl.dondevamos.backend.repository.UsuarioAppRepository;
import cl.dondevamos.backend.repository.EventoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    private final ComentarioRepository repository;
    private final ComentarioMapper mapper;
    private final UsuarioAppRepository usuarioAppRepository;
    private final EventoRepository eventoRepository;

    public ComentarioServiceImpl(ComentarioRepository repository, ComentarioMapper mapper, 
                               UsuarioAppRepository usuarioAppRepository, EventoRepository eventoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.usuarioAppRepository = usuarioAppRepository;
        this.eventoRepository = eventoRepository;
    }

    @Override
    public ComentarioResponseDTO crear(ComentarioRequestDTO comentario) {
        UsuarioApp usuarioApp = usuarioAppRepository.findById(comentario.getIdUsuarioApp())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + comentario.getIdUsuarioApp()));
        Evento evento = eventoRepository.findById(comentario.getIdEvento())
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con id: " + comentario.getIdEvento()));
        
        Comentario entity = mapper.toEntity(comentario);
        entity.setUsuarioApp(usuarioApp);
        entity.setEvento(evento);
        Comentario saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public ComentarioResponseDTO obtenerPorId(Integer id) {
        Comentario entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<ComentarioResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ComentarioResponseDTO actualizar(Integer id, ComentarioRequestDTO comentario) {
        Comentario entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado con id: " + id));
        
        if (comentario.getIdUsuarioApp() != null && !comentario.getIdUsuarioApp().equals(entity.getUsuarioApp().getIdUsuarioApp())) {
            UsuarioApp usuarioApp = usuarioAppRepository.findById(comentario.getIdUsuarioApp())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + comentario.getIdUsuarioApp()));
            entity.setUsuarioApp(usuarioApp);
        }
        
        if (comentario.getIdEvento() != null && !comentario.getIdEvento().equals(entity.getEvento().getIdEvento())) {
            Evento evento = eventoRepository.findById(comentario.getIdEvento())
                    .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con id: " + comentario.getIdEvento()));
            entity.setEvento(evento);
        }
        
        mapper.updateEntity(comentario, entity);
        Comentario updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        Comentario entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado con id: " + id));
        repository.delete(entity);
    }
}
