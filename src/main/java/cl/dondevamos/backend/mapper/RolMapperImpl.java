package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.RolRequestDTO;
import cl.dondevamos.backend.dto.response.RolResponseDTO;
import cl.dondevamos.backend.entity.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolMapperImpl implements RolMapper {
    @Override
    public Rol toEntity(RolRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Rol.builder()
                .codigo(dto.getCodigo())
                .nombre(dto.getNombre())
                .build();
    }

    @Override
    public RolResponseDTO toResponseDTO(Rol entity) {
        if (entity == null) {
            return null;
        }
        return RolResponseDTO.builder()
                .idRol(entity.getIdRol())
                .codigo(entity.getCodigo())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public void updateEntity(RolRequestDTO dto, Rol entity) {
        if (dto == null) {
            return;
        }
        entity.setCodigo(dto.getCodigo());
        entity.setNombre(dto.getNombre());
    }
}
