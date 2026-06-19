package cl.dondevamos.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comentario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer idComentario;

    @ManyToOne
    @JoinColumn(name = "id_usuario_app", nullable = false)
    private UsuarioApp usuarioApp;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "opinion", columnDefinition = "TEXT")
    private String opinion;

    @Column(name = "calidad", length = 50)
    private String calidad;
}
