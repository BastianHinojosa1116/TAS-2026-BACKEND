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
public class ProvinciaRequestDTO {
    @NotBlank(message = "El nombre de la provincia es requerido")
    private String nombre;
}
