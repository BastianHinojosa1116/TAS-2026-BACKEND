package cl.dondevamos.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioMunicipioResponseDTO {
    private Integer idUsuarioMunicipio;
    private String nombreResponsable;
    private String correo;
    private String telefono;
    private String estado;
    private LocalDateTime fechaCreacion;
    private RolResponseDTO rol;
    private MunicipioResponseDTO municipio;
}
