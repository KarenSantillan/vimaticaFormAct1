package com.viamatica.santillank.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Materia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_materia", nullable = false)
    private int idMateria;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;
    @Basic
    @Column(name = "puntos", nullable = false, length = 45)
    private String puntos;
    @OneToMany(mappedBy = "materiaByIdMateria")
    private Collection<Alumnohasmaterias> alumnohasmateriasByIdMateria;

}
