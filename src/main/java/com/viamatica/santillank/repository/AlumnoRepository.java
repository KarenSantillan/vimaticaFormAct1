package com.viamatica.santillank.repository;

import com.viamatica.santillank.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    List<Alumno> findByNombreContaining(String alumName);

    //mejores promedios alumnos

    @Query(value = "SELECT a.* FROM alumnohasmaterias ahm JOIN alumno a ON ahm.id_alumno = a.id_alumno JOIN materia m ON ahm.id_materia = m.id_materia WHERE m.descripcion LIKE ?1 GROUP BY ahm.id_alumno ORDER BY AVG(m.puntos) DESC LIMIT ?2 ", nativeQuery = true)
    List<Alumno> findAlumByMateriaOrderByPunt(String nomMateria, int n);

}
