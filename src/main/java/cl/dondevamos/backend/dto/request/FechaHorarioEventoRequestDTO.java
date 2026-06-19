package cl.dondevamos.backend.dto.request;

import jakarta.validation.constraints.NotNull;
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
public class FechaHorarioEventoRequestDTO {
    @NotNull(message = "La fecha es requerida")
    private LocalDate fecha;

    @NotNull(message = "El horario es requerido")
    private LocalTime horario;

    @NotNull(message = "El ID del evento es requerido")
    private Integer idEvento;
}
