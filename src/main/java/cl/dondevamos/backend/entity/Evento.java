package cl.dondevamos.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "Evento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer idEvento;

    @Column(name = "nombre_evento", nullable = false, length = 200)
    private String nombreEvento;

    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;

    @Column(name = "imagen", length = 500)
    private String imagen;

    @Column(name = "es_pagado", nullable = false)
    private Boolean esPagado;

    @Column(name = "descripcion_evento", columnDefinition = "TEXT")
    private String descripcionEvento;

    @Column(name = "pet_friendly", nullable = false)
    private Boolean petFriendly;

    @Column(name = "accesibilidad_discapacidad", nullable = false)
    private Boolean accesibilidadDiscapacidad;

    @Column(name = "estacionamiento", nullable = false)
    private Boolean estacionamiento;

    @Column(name = "qr", length = 500)
    private String qr;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

    @ManyToMany
    @JoinTable(
            name = "EventoCategoria",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private Set<Categoria> categorias;
}
