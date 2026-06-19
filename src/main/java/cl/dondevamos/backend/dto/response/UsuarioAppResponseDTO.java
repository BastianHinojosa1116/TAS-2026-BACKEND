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
public class UsuarioAppResponseDTO {
    private Integer idUsuarioApp;
    private String nombre;
    private String correo;
    private String estado;
    private LocalDateTime fechaCreacion;
    private String firebaseUid;
}
