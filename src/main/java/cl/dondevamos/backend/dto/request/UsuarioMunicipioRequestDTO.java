package cl.dondevamos.backend.dto.request;

import jakarta.validation.constraints.Email;
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
public class UsuarioMunicipioRequestDTO {
    @NotBlank(message = "El nombre del responsable es requerido")
    private String nombreResponsable;

    @NotBlank(message = "El correo es requerido")
    @Email(message = "El correo debe ser válido")
    private String correo;

    private String telefono;

    @NotBlank(message = "El estado es requerido")
    private String estado;

    @NotNull(message = "El ID del rol es requerido")
    private Integer idRol;

    @NotNull(message = "El ID del municipio es requerido")
    private Integer idMunicipio;
}
