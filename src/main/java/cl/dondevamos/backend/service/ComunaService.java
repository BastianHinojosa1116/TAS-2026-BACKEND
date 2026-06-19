package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.ComunaRequestDTO;
import cl.dondevamos.backend.dto.response.ComunaResponseDTO;

import java.util.List;

public interface ComunaService {
    ComunaResponseDTO crear(ComunaRequestDTO comuna);
    ComunaResponseDTO obtenerPorId(Integer id);
    List<ComunaResponseDTO> obtenerTodos();
    ComunaResponseDTO actualizar(Integer id, ComunaRequestDTO comuna);
    void eliminar(Integer id);
}
