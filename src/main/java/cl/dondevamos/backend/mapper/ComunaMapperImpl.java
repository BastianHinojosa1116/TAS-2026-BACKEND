package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.ComunaRequestDTO;
import cl.dondevamos.backend.dto.response.ComunaResponseDTO;
import cl.dondevamos.backend.entity.Comuna;
import org.springframework.stereotype.Component;

@Component
public class ComunaMapperImpl implements ComunaMapper {
    private final ProvinciaMapper provinciaMapper;

    public ComunaMapperImpl(ProvinciaMapper provinciaMapper) {
        this.provinciaMapper = provinciaMapper;
    }

    @Override
    public Comuna toEntity(ComunaRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Comuna.builder()
                .nombre(dto.getNombre())
                .build();
    }

    @Override
    public ComunaResponseDTO toResponseDTO(Comuna entity) {
        if (entity == null) {
            return null;
        }
        return ComunaResponseDTO.builder()
                .idComuna(entity.getIdComuna())
                .nombre(entity.getNombre())
                .provincia(entity.getProvincia() != null ? provinciaMapper.toResponseDTO(entity.getProvincia()) : null)
                .build();
    }

    @Override
    public void updateEntity(ComunaRequestDTO dto, Comuna entity) {
        if (dto == null) {
            return;
        }
        entity.setNombre(dto.getNombre());
    }
}
