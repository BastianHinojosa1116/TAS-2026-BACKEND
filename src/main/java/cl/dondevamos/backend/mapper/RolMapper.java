package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.RolRequestDTO;
import cl.dondevamos.backend.dto.response.RolResponseDTO;
import cl.dondevamos.backend.entity.Rol;

public interface RolMapper {
    Rol toEntity(RolRequestDTO dto);
    RolResponseDTO toResponseDTO(Rol entity);
    void updateEntity(RolRequestDTO dto, Rol entity);
}
