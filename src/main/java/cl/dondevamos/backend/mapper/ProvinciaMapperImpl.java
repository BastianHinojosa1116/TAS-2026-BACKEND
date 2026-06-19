package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.ProvinciaRequestDTO;
import cl.dondevamos.backend.dto.response.ProvinciaResponseDTO;
import cl.dondevamos.backend.entity.Provincia;
import org.springframework.stereotype.Component;

@Component
public class ProvinciaMapperImpl implements ProvinciaMapper {
    @Override
    public Provincia toEntity(ProvinciaRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Provincia.builder()
                .nombre(dto.getNombre())
                .build();
    }

    @Override
    public ProvinciaResponseDTO toResponseDTO(Provincia entity) {
        if (entity == null) {
            return null;
        }
        return ProvinciaResponseDTO.builder()
                .idProvincia(entity.getIdProvincia())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public void updateEntity(ProvinciaRequestDTO dto, Provincia entity) {
        if (dto == null) {
            return;
        }
        entity.setNombre(dto.getNombre());
    }
}
