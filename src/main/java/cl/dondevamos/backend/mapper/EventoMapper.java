package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.EventoRequestDTO;
import cl.dondevamos.backend.dto.response.EventoResponseDTO;
import cl.dondevamos.backend.entity.Evento;

public interface EventoMapper {
    Evento toEntity(EventoRequestDTO dto);
    EventoResponseDTO toResponseDTO(Evento entity);
    void updateEntity(EventoRequestDTO dto, Evento entity);
}
