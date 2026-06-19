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
public class AsistenciaEventoResponseDTO {
    private Integer idAsistenciaEvento;
    private UsuarioAppResponseDTO usuarioApp;
    private EventoResponseDTO evento;
    private LocalDateTime fechaRegistro;
    private Boolean estado;
}
