package cl.dondevamos.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolRequestDTO {
    @NotBlank(message = "El código del rol es requerido")
    private String codigo;

    @NotBlank(message = "El nombre del rol es requerido")
    private String nombre;
}
