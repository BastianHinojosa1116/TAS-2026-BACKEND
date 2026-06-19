package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.ProvinciaRequestDTO;
import cl.dondevamos.backend.dto.response.ProvinciaResponseDTO;

import java.util.List;

public interface ProvinciaService {
    ProvinciaResponseDTO crear(ProvinciaRequestDTO provincia);
    ProvinciaResponseDTO obtenerPorId(Integer id);
    List<ProvinciaResponseDTO> obtenerTodos();
    ProvinciaResponseDTO actualizar(Integer id, ProvinciaRequestDTO provincia);
    void eliminar(Integer id);
}
