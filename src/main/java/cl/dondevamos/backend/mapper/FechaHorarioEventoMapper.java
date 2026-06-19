package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.FechaHorarioEventoRequestDTO;
import cl.dondevamos.backend.dto.response.FechaHorarioEventoResponseDTO;
import cl.dondevamos.backend.entity.FechaHorarioEvento;

public interface FechaHorarioEventoMapper {
    FechaHorarioEvento toEntity(FechaHorarioEventoRequestDTO dto);
    FechaHorarioEventoResponseDTO toResponseDTO(FechaHorarioEvento entity);
    void updateEntity(FechaHorarioEventoRequestDTO dto, FechaHorarioEvento entity);
}
