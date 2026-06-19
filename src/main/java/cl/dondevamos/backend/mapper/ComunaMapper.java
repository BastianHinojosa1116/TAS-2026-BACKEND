package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.ComunaRequestDTO;
import cl.dondevamos.backend.dto.response.ComunaResponseDTO;
import cl.dondevamos.backend.entity.Comuna;

public interface ComunaMapper {
    Comuna toEntity(ComunaRequestDTO dto);
    ComunaResponseDTO toResponseDTO(Comuna entity);
    void updateEntity(ComunaRequestDTO dto, Comuna entity);
}
