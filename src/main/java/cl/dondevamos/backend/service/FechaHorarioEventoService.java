package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.FechaHorarioEventoRequestDTO;
import cl.dondevamos.backend.dto.response.FechaHorarioEventoResponseDTO;

import java.util.List;

public interface FechaHorarioEventoService {
    FechaHorarioEventoResponseDTO crear(FechaHorarioEventoRequestDTO fechaHorario);
    FechaHorarioEventoResponseDTO obtenerPorId(Integer id);
    List<FechaHorarioEventoResponseDTO> obtenerTodos();
    FechaHorarioEventoResponseDTO actualizar(Integer id, FechaHorarioEventoRequestDTO fechaHorario);
    void eliminar(Integer id);
}
