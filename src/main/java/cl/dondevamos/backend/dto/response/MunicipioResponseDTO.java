package cl.dondevamos.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MunicipioResponseDTO {
    private Integer idMunicipio;
    private String nombre;
    private String estado;
    private ComunaResponseDTO comuna;
}
