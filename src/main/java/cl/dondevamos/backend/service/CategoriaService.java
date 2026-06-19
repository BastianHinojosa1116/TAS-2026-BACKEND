package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.CategoriaRequestDTO;
import cl.dondevamos.backend.dto.response.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaResponseDTO crear(CategoriaRequestDTO categoria);
    CategoriaResponseDTO obtenerPorId(Integer id);
    List<CategoriaResponseDTO> obtenerTodos();
    CategoriaResponseDTO actualizar(Integer id, CategoriaRequestDTO categoria);
    void eliminar(Integer id);
}
