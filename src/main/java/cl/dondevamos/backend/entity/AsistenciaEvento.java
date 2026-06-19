package cl.dondevamos.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "AsistenciaEvento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsistenciaEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia_evento")
    private Integer idAsistenciaEvento;

    @ManyToOne
    @JoinColumn(name = "id_usuario_app", nullable = false)
    private UsuarioApp usuarioApp;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
