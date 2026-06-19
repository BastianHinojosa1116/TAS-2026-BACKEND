package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.MunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.MunicipioResponseDTO;
import cl.dondevamos.backend.entity.Municipio;

public interface MunicipioMapper {
    Municipio toEntity(MunicipioRequestDTO dto);
    MunicipioResponseDTO toResponseDTO(Municipio entity);
    void updateEntity(MunicipioRequestDTO dto, Municipio entity);
}
