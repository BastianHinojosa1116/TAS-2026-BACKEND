package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.UsuarioMunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioMunicipioResponseDTO;

import java.util.List;

public interface UsuarioMunicipioService {
    UsuarioMunicipioResponseDTO crear(UsuarioMunicipioRequestDTO usuario);
    UsuarioMunicipioResponseDTO obtenerPorId(Integer id);
    List<UsuarioMunicipioResponseDTO> obtenerTodos();
    UsuarioMunicipioResponseDTO actualizar(Integer id, UsuarioMunicipioRequestDTO usuario);
    void eliminar(Integer id);
}
