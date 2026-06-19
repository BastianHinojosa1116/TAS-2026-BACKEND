package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.RolRequestDTO;
import cl.dondevamos.backend.dto.response.RolResponseDTO;

import java.util.List;

public interface RolService {
    RolResponseDTO crear(RolRequestDTO rol);
    RolResponseDTO obtenerPorId(Integer id);
    List<RolResponseDTO> obtenerTodos();
    RolResponseDTO actualizar(Integer id, RolRequestDTO rol);
    void eliminar(Integer id);
}
