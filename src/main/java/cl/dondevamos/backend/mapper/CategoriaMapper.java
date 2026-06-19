package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.CategoriaRequestDTO;
import cl.dondevamos.backend.dto.response.CategoriaResponseDTO;
import cl.dondevamos.backend.entity.Categoria;

public interface CategoriaMapper {
    Categoria toEntity(CategoriaRequestDTO dto);
    CategoriaResponseDTO toResponseDTO(Categoria entity);
    void updateEntity(CategoriaRequestDTO dto, Categoria entity);
}
