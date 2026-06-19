package cl.dondevamos.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoRequestDTO {
    @NotBlank(message = "El nombre del evento es requerido")
    private String nombreEvento;

    @NotBlank(message = "La dirección es requerida")
    private String direccion;

    private String imagen;

    @NotNull(message = "El campo esPagado es requerido")
    private Boolean esPagado;

    private String descripcionEvento;

    @NotNull(message = "El campo petFriendly es requerido")
    private Boolean petFriendly;

    @NotNull(message = "El campo accesibilidadDiscapacidad es requerido")
    private Boolean accesibilidadDiscapacidad;

    @NotNull(message = "El campo estacionamiento es requerido")
    private Boolean estacionamiento;

    private String qr;

    @NotBlank(message = "El estado es requerido")
    private String estado;

    @NotNull(message = "El ID del municipio es requerido")
    private Integer idMunicipio;

    private Set<Integer> idCategorias;
}
