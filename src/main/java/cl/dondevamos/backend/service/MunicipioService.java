package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.MunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.MunicipioResponseDTO;

import java.util.List;

public interface MunicipioService {
    MunicipioResponseDTO crear(MunicipioRequestDTO municipio);
    MunicipioResponseDTO obtenerPorId(Integer id);
    List<MunicipioResponseDTO> obtenerTodos();
    MunicipioResponseDTO actualizar(Integer id, MunicipioRequestDTO municipio);
    void eliminar(Integer id);
}
