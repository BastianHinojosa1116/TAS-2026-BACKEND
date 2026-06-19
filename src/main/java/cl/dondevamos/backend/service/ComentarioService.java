package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.ComentarioRequestDTO;
import cl.dondevamos.backend.dto.response.ComentarioResponseDTO;

import java.util.List;

public interface ComentarioService {
    ComentarioResponseDTO crear(ComentarioRequestDTO comentario);
    ComentarioResponseDTO obtenerPorId(Integer id);
    List<ComentarioResponseDTO> obtenerTodos();
    ComentarioResponseDTO actualizar(Integer id, ComentarioRequestDTO comentario);
    void eliminar(Integer id);
}
