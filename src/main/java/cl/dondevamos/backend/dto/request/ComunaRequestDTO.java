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
public class ComunaRequestDTO {
    @NotBlank(message = "El nombre de la comuna es requerido")
    private String nombre;

    @NotNull(message = "El ID de provincia es requerido")
    private Integer idProvincia;
}
