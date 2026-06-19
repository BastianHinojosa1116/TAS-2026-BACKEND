package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.CategoriaRequestDTO;
import cl.dondevamos.backend.dto.response.CategoriaResponseDTO;
import cl.dondevamos.backend.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapperImpl implements CategoriaMapper {
    @Override
    public Categoria toEntity(CategoriaRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Categoria.builder()
                .nombre(dto.getNombre())
                .build();
    }

    @Override
    public CategoriaResponseDTO toResponseDTO(Categoria entity) {
        if (entity == null) {
            return null;
        }
        return CategoriaResponseDTO.builder()
                .idCategoria(entity.getIdCategoria())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public void updateEntity(CategoriaRequestDTO dto, Categoria entity) {
        if (dto == null) {
            return;
        }
        entity.setNombre(dto.getNombre());
    }
}
