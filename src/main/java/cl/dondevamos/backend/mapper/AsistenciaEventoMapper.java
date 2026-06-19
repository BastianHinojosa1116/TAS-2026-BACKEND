package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.AsistenciaEventoRequestDTO;
import cl.dondevamos.backend.dto.response.AsistenciaEventoResponseDTO;
import cl.dondevamos.backend.entity.AsistenciaEvento;

public interface AsistenciaEventoMapper {
    AsistenciaEvento toEntity(AsistenciaEventoRequestDTO dto);
    AsistenciaEventoResponseDTO toResponseDTO(AsistenciaEvento entity);
    void updateEntity(AsistenciaEventoRequestDTO dto, AsistenciaEvento entity);
}
