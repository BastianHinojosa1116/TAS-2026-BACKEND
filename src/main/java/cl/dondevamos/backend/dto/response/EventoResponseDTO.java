package cl.dondevamos.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoResponseDTO {
    private Integer idEvento;
    private String nombreEvento;
    private String direccion;
    private String imagen;
    private Boolean esPagado;
    private String descripcionEvento;
    private Boolean petFriendly;
    private Boolean accesibilidadDiscapacidad;
    private Boolean estacionamiento;
    private String qr;
    private String estado;
    private MunicipioResponseDTO municipio;
    private Set<CategoriaResponseDTO> categorias;
}
