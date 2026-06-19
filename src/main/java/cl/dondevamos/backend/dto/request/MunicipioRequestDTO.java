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
public class MunicipioRequestDTO {
    @NotBlank(message = "El nombre del municipio es requerido")
    private String nombre;

    @NotBlank(message = "El estado es requerido")
    private String estado;

    @NotNull(message = "El ID de comuna es requerido")
    private Integer idComuna;
}
