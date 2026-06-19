package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.ComentarioRequestDTO;
import cl.dondevamos.backend.dto.response.ComentarioResponseDTO;
import cl.dondevamos.backend.entity.Comentario;

public interface ComentarioMapper {
    Comentario toEntity(ComentarioRequestDTO dto);
    ComentarioResponseDTO toResponseDTO(Comentario entity);
    void updateEntity(ComentarioRequestDTO dto, Comentario entity);
}
