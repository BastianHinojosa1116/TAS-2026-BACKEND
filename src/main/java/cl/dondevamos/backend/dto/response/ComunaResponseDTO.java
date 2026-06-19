package cl.dondevamos.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComunaResponseDTO {
    private Integer idComuna;
    private String nombre;
    private ProvinciaResponseDTO provincia;
}
