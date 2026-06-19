package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.UsuarioMunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioMunicipioResponseDTO;
import cl.dondevamos.backend.entity.UsuarioMunicipio;

public interface UsuarioMunicipioMapper {
    UsuarioMunicipio toEntity(UsuarioMunicipioRequestDTO dto);
    UsuarioMunicipioResponseDTO toResponseDTO(UsuarioMunicipio entity);
    void updateEntity(UsuarioMunicipioRequestDTO dto, UsuarioMunicipio entity);
}
