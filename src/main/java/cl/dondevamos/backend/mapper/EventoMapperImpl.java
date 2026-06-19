package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.EventoRequestDTO;
import cl.dondevamos.backend.dto.response.EventoResponseDTO;
import cl.dondevamos.backend.entity.Evento;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class EventoMapperImpl implements EventoMapper {
    private final MunicipioMapper municipioMapper;
    private final CategoriaMapper categoriaMapper;

    public EventoMapperImpl(MunicipioMapper municipioMapper, CategoriaMapper categoriaMapper) {
        this.municipioMapper = municipioMapper;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public Evento toEntity(EventoRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Evento.builder()
                .nombreEvento(dto.getNombreEvento())
                .direccion(dto.getDireccion())
                .imagen(dto.getImagen())
                .esPagado(dto.getEsPagado())
                .descripcionEvento(dto.getDescripcionEvento())
                .petFriendly(dto.getPetFriendly())
                .accesibilidadDiscapacidad(dto.getAccesibilidadDiscapacidad())
                .estacionamiento(dto.getEstacionamiento())
                .qr(dto.getQr())
                .estado(dto.getEstado())
                .build();
    }

    @Override
    public EventoResponseDTO toResponseDTO(Evento entity) {
        if (entity == null) {
            return null;
        }
        return EventoResponseDTO.builder()
                .idEvento(entity.getIdEvento())
                .nombreEvento(entity.getNombreEvento())
                .direccion(entity.getDireccion())
                .imagen(entity.getImagen())
                .esPagado(entity.getEsPagado())
                .descripcionEvento(entity.getDescripcionEvento())
                .petFriendly(entity.getPetFriendly())
                .accesibilidadDiscapacidad(entity.getAccesibilidadDiscapacidad())
                .estacionamiento(entity.getEstacionamiento())
                .qr(entity.getQr())
                .estado(entity.getEstado())
                .municipio(entity.getMunicipio() != null ? municipioMapper.toResponseDTO(entity.getMunicipio()) : null)
                .categorias(entity.getCategorias() != null ? 
                    entity.getCategorias().stream()
                        .map(categoriaMapper::toResponseDTO)
                        .collect(Collectors.toSet()) : null)
                .build();
    }

    @Override
    public void updateEntity(EventoRequestDTO dto, Evento entity) {
        if (dto == null) {
            return;
        }
        entity.setNombreEvento(dto.getNombreEvento());
        entity.setDireccion(dto.getDireccion());
        entity.setImagen(dto.getImagen());
        entity.setEsPagado(dto.getEsPagado());
        entity.setDescripcionEvento(dto.getDescripcionEvento());
        entity.setPetFriendly(dto.getPetFriendly());
        entity.setAccesibilidadDiscapacidad(dto.getAccesibilidadDiscapacidad());
        entity.setEstacionamiento(dto.getEstacionamiento());
        entity.setQr(dto.getQr());
        entity.setEstado(dto.getEstado());
    }
}
