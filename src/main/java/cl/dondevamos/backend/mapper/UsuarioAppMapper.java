package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.UsuarioAppRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioAppResponseDTO;
import cl.dondevamos.backend.entity.UsuarioApp;

public interface UsuarioAppMapper {
    UsuarioApp toEntity(UsuarioAppRequestDTO dto);
    UsuarioAppResponseDTO toResponseDTO(UsuarioApp entity);
    void updateEntity(UsuarioAppRequestDTO dto, UsuarioApp entity);
}
