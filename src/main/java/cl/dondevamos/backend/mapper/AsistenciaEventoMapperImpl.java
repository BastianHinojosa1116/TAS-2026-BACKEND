package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.AsistenciaEventoRequestDTO;
import cl.dondevamos.backend.dto.response.AsistenciaEventoResponseDTO;
import cl.dondevamos.backend.entity.AsistenciaEvento;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class AsistenciaEventoMapperImpl implements AsistenciaEventoMapper {
    private final UsuarioAppMapper usuarioAppMapper;
    private final EventoMapper eventoMapper;

    public AsistenciaEventoMapperImpl(UsuarioAppMapper usuarioAppMapper, EventoMapper eventoMapper) {
        this.usuarioAppMapper = usuarioAppMapper;
        this.eventoMapper = eventoMapper;
    }

    @Override
    public AsistenciaEvento toEntity(AsistenciaEventoRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return AsistenciaEvento.builder()
                .fechaRegistro(LocalDateTime.now())
                .estado(dto.getEstado())
                .build();
    }

    @Override
    public AsistenciaEventoResponseDTO toResponseDTO(AsistenciaEvento entity) {
        if (entity == null) {
            return null;
        }
        return AsistenciaEventoResponseDTO.builder()
                .idAsistenciaEvento(entity.getIdAsistenciaEvento())
                .usuarioApp(entity.getUsuarioApp() != null ? usuarioAppMapper.toResponseDTO(entity.getUsuarioApp()) : null)
                .evento(entity.getEvento() != null ? eventoMapper.toResponseDTO(entity.getEvento()) : null)
                .fechaRegistro(entity.getFechaRegistro())
                .estado(entity.getEstado())
                .build();
    }

    @Override
    public void updateEntity(AsistenciaEventoRequestDTO dto, AsistenciaEvento entity) {
        if (dto == null) {
            return;
        }
        entity.setEstado(dto.getEstado());
    }
}
