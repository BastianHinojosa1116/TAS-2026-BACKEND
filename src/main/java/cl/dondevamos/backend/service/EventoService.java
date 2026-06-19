package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.EventoRequestDTO;
import cl.dondevamos.backend.dto.response.EventoResponseDTO;

import java.util.List;

public interface EventoService {
    EventoResponseDTO crear(EventoRequestDTO evento);
    EventoResponseDTO obtenerPorId(Integer id);
    List<EventoResponseDTO> obtenerTodos();
    EventoResponseDTO actualizar(Integer id, EventoRequestDTO evento);
    void eliminar(Integer id);
}
