package cl.dondevamos.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsistenciaEventoRequestDTO {
    @NotNull(message = "El ID del usuario es requerido")
    private Integer idUsuarioApp;

    @NotNull(message = "El ID del evento es requerido")
    private Integer idEvento;

    @NotNull(message = "El estado es requerido")
    private Boolean estado;
}
