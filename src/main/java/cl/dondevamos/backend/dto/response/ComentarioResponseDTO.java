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
public class ComentarioResponseDTO {
    private Integer idComentario;
    private UsuarioAppResponseDTO usuarioApp;
    private EventoResponseDTO evento;
    private LocalDateTime fecha;
    private String opinion;
    private String calidad;
}
