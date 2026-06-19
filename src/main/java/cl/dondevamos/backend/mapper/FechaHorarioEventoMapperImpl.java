package cl.dondevamos.backend.mapper;

import cl.dondevamos.backend.dto.request.FechaHorarioEventoRequestDTO;
import cl.dondevamos.backend.dto.response.FechaHorarioEventoResponseDTO;
import cl.dondevamos.backend.entity.FechaHorarioEvento;
import org.springframework.stereotype.Component;

@Component
public class FechaHorarioEventoMapperImpl implements FechaHorarioEventoMapper {
    @Override
    public FechaHorarioEvento toEntity(FechaHorarioEventoRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return FechaHorarioEvento.builder()
                .fecha(dto.getFecha())
                .horario(dto.getHorario())
                .build();
    }

    @Override
    public FechaHorarioEventoResponseDTO toResponseDTO(FechaHorarioEvento entity) {
        if (entity == null) {
            return null;
        }
        return FechaHorarioEventoResponseDTO.builder()
                .idFechaHorarioEvento(entity.getIdFechaHorarioEvento())
                .fecha(entity.getFecha())
                .horario(entity.getHorario())
                .idEvento(entity.getEvento() != null ? entity.getEvento().getIdEvento() : null)
                .build();
    }

    @Override
    public void updateEntity(FechaHorarioEventoRequestDTO dto, FechaHorarioEvento entity) {
        if (dto == null) {
            return;
        }
        entity.setFecha(dto.getFecha());
        entity.setHorario(dto.getHorario());
    }
}
