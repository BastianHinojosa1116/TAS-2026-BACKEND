package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.AsistenciaEventoRequestDTO;
import cl.dondevamos.backend.dto.response.AsistenciaEventoResponseDTO;

import java.util.List;

public interface AsistenciaEventoService {
    AsistenciaEventoResponseDTO crear(AsistenciaEventoRequestDTO asistencia);
    AsistenciaEventoResponseDTO obtenerPorId(Integer id);
    List<AsistenciaEventoResponseDTO> obtenerTodos();
    AsistenciaEventoResponseDTO actualizar(Integer id, AsistenciaEventoRequestDTO asistencia);
    void eliminar(Integer id);
}
