package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.ProvinciaRequestDTO;
import cl.dondevamos.backend.dto.response.ProvinciaResponseDTO;
import cl.dondevamos.backend.entity.Provincia;

public interface ProvinciaMapper {
    Provincia toEntity(ProvinciaRequestDTO dto);
    ProvinciaResponseDTO toResponseDTO(Provincia entity);
    void updateEntity(ProvinciaRequestDTO dto, Provincia entity);
}
