package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.UsuarioAppRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioAppResponseDTO;
import cl.dondevamos.backend.entity.UsuarioApp;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UsuarioAppMapperImpl implements UsuarioAppMapper {
    @Override
    public UsuarioApp toEntity(UsuarioAppRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return UsuarioApp.builder()
                .nombre(dto.getNombre())
                .correo(dto.getCorreo())
                .estado(dto.getEstado())
                .firebaseUid(dto.getFirebaseUid())
                .fechaCreacion(LocalDateTime.now())
                .build();
    }

    @Override
    public UsuarioAppResponseDTO toResponseDTO(UsuarioApp entity) {
        if (entity == null) {
            return null;
        }
        return UsuarioAppResponseDTO.builder()
                .idUsuarioApp(entity.getIdUsuarioApp())
                .nombre(entity.getNombre())
                .correo(entity.getCorreo())
                .estado(entity.getEstado())
                .fechaCreacion(entity.getFechaCreacion())
                .firebaseUid(entity.getFirebaseUid())
                .build();
    }

    @Override
    public void updateEntity(UsuarioAppRequestDTO dto, UsuarioApp entity) {
        if (dto == null) {
            return;
        }
        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        entity.setEstado(dto.getEstado());
        if (dto.getFirebaseUid() != null) {
            entity.setFirebaseUid(dto.getFirebaseUid());
        }
    }
}
