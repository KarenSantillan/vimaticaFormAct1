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
public class Maestro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_maestro", nullable = false)
    private int idMaestro;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Basic
    @Column(name = "titulo", nullable = false, length = 45)
    private String titulo;
    @OneToMany(mappedBy = "maestroByIdMaestro")
    private Collection<Alumno> alumnosByIdMaestro;

}
