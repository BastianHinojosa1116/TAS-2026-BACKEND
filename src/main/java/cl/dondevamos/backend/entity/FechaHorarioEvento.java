package cl.dondevamos.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "FechaHorarioEvento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FechaHorarioEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fecha_horario_evento")
    private Integer idFechaHorarioEvento;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "horario", nullable = false)
    private LocalTime horario;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;
}
