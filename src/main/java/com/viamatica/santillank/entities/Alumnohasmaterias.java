package com.viamatica.santillank.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alumnohasmaterias {
/*
    @Basic
    @Column(name = "idAlumno", nullable = true)
    private Integer idAlumno;
    @Basic
    @Column(name = "idMateria", nullable = true)
    private Integer idMateria;*/
    @Id
    @Basic
//    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    private Alumno alumnoByIdAlumno;
    @ManyToOne
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    private Materia materiaByIdMateria;



}
