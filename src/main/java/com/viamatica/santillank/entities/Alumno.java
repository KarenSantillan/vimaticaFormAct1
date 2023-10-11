package com.viamatica.santillank.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alumno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_alumno", nullable = false)
    private int idAlumno;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @ManyToOne
    @JoinColumn(name = "id_maestro", referencedColumnName = "id_maestro")
    private Maestro maestroByIdMaestro;

    @OneToMany(mappedBy = "alumnoByIdAlumno")
    private Collection<Alumnohasmaterias> alumnohasmateriasByIdAlumno;

}
