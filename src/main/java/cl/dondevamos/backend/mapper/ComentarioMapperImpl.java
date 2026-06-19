package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.ComentarioRequestDTO;
import cl.dondevamos.backend.dto.response.ComentarioResponseDTO;
import cl.dondevamos.backend.entity.Comentario;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ComentarioMapperImpl implements ComentarioMapper {
    private final UsuarioAppMapper usuarioAppMapper;
    private final EventoMapper eventoMapper;

    public ComentarioMapperImpl(UsuarioAppMapper usuarioAppMapper, EventoMapper eventoMapper) {
        this.usuarioAppMapper = usuarioAppMapper;
        this.eventoMapper = eventoMapper;
    }

    @Override
    public Comentario toEntity(ComentarioRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Comentario.builder()
                .fecha(LocalDateTime.now())
                .opinion(dto.getOpinion())
                .calidad(dto.getCalidad())
                .build();
    }

    @Override
    public ComentarioResponseDTO toResponseDTO(Comentario entity) {
        if (entity == null) {
            return null;
        }
        return ComentarioResponseDTO.builder()
                .idComentario(entity.getIdComentario())
                .usuarioApp(entity.getUsuarioApp() != null ? usuarioAppMapper.toResponseDTO(entity.getUsuarioApp()) : null)
                .evento(entity.getEvento() != null ? eventoMapper.toResponseDTO(entity.getEvento()) : null)
                .fecha(entity.getFecha())
                .opinion(entity.getOpinion())
                .calidad(entity.getCalidad())
                .build();
    }

    @Override
    public void updateEntity(ComentarioRequestDTO dto, Comentario entity) {
        if (dto == null) {
            return;
        }
        entity.setOpinion(dto.getOpinion());
        entity.setCalidad(dto.getCalidad());
    }
}
