package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.UsuarioMunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioMunicipioResponseDTO;
import cl.dondevamos.backend.entity.UsuarioMunicipio;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UsuarioMunicipioMapperImpl implements UsuarioMunicipioMapper {
    private final RolMapper rolMapper;
    private final MunicipioMapper municipioMapper;

    public UsuarioMunicipioMapperImpl(RolMapper rolMapper, MunicipioMapper municipioMapper) {
        this.rolMapper = rolMapper;
        this.municipioMapper = municipioMapper;
    }

    @Override
    public UsuarioMunicipio toEntity(UsuarioMunicipioRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return UsuarioMunicipio.builder()
                .nombreResponsable(dto.getNombreResponsable())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .estado(dto.getEstado())
                .fechaCreacion(LocalDateTime.now())
                .build();
    }

    @Override
    public UsuarioMunicipioResponseDTO toResponseDTO(UsuarioMunicipio entity) {
        if (entity == null) {
            return null;
        }
        return UsuarioMunicipioResponseDTO.builder()
                .idUsuarioMunicipio(entity.getIdUsuarioMunicipio())
                .nombreResponsable(entity.getNombreResponsable())
                .correo(entity.getCorreo())
                .telefono(entity.getTelefono())
                .estado(entity.getEstado())
                .fechaCreacion(entity.getFechaCreacion())
                .rol(entity.getRol() != null ? rolMapper.toResponseDTO(entity.getRol()) : null)
                .municipio(entity.getMunicipio() != null ? municipioMapper.toResponseDTO(entity.getMunicipio()) : null)
                .build();
    }

    @Override
    public void updateEntity(UsuarioMunicipioRequestDTO dto, UsuarioMunicipio entity) {
        if (dto == null) {
            return;
        }
        entity.setNombreResponsable(dto.getNombreResponsable());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        entity.setEstado(dto.getEstado());
    }
}
