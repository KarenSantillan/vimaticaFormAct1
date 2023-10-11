package com.viamatica.santillank.repository;

import com.viamatica.santillank.entities.Alumno;
import com.viamatica.santillank.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    @Query(value = "SELECT m.* FROM alumnohasmaterias ahm JOIN materia m ON ahm.id_materia = m.id_materia JOIN alumno a ON ahm.id_alumno = a.id_alumno WHERE a.nombre LIKE ?1 AND m.puntos >= ?2 GROUP BY ahm.id_materia ORDER BY AVG(m.puntos) DESC LIMIT 1", nativeQuery = true)
    Materia findMateriaByPuntaje(String estudiante, @Param("s") int puntaje);
}
