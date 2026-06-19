package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.MunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.MunicipioResponseDTO;
import cl.dondevamos.backend.entity.Municipio;
import org.springframework.stereotype.Component;

@Component
public class MunicipioMapperImpl implements MunicipioMapper {
    private final ComunaMapper comunaMapper;

    public MunicipioMapperImpl(ComunaMapper comunaMapper) {
        this.comunaMapper = comunaMapper;
    }

    @Override
    public Municipio toEntity(MunicipioRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Municipio.builder()
                .nombre(dto.getNombre())
                .estado(dto.getEstado())
                .build();
    }

    @Override
    public MunicipioResponseDTO toResponseDTO(Municipio entity) {
        if (entity == null) {
            return null;
        }
        return MunicipioResponseDTO.builder()
                .idMunicipio(entity.getIdMunicipio())
                .nombre(entity.getNombre())
                .estado(entity.getEstado())
                .comuna(entity.getComuna() != null ? comunaMapper.toResponseDTO(entity.getComuna()) : null)
                .build();
    }

    @Override
    public void updateEntity(MunicipioRequestDTO dto, Municipio entity) {
        if (dto == null) {
            return;
        }
        entity.setNombre(dto.getNombre());
        entity.setEstado(dto.getEstado());
    }
}
