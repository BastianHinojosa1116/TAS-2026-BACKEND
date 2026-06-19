package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.UsuarioAppRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioAppResponseDTO;

import java.util.List;

public interface UsuarioAppService {
    UsuarioAppResponseDTO crear(UsuarioAppRequestDTO usuario);
    UsuarioAppResponseDTO obtenerPorId(Integer id);
    List<UsuarioAppResponseDTO> obtenerTodos();
    UsuarioAppResponseDTO actualizar(Integer id, UsuarioAppRequestDTO usuario);
    void eliminar(Integer id);
}
