package cl.dondevamos.backend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioRequestDTO {
    @NotNull(message = "El ID del usuario es requerido")
    private Integer idUsuarioApp;

    @NotNull(message = "El ID del evento es requerido")
    private Integer idEvento;

    private String opinion;

    private String calidad;
}
