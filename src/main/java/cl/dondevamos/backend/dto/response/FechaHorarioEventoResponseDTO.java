package cl.dondevamos.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FechaHorarioEventoResponseDTO {
    private Integer idFechaHorarioEvento;
    private LocalDate fecha;
    private LocalTime horario;
    private Integer idEvento;
}
