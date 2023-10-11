package com.viamatica.santillank.repository;

import com.viamatica.santillank.entities.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaestroRepository extends JpaRepository<Maestro, Integer> {
    //Buscar maestros por nombre
    List<Maestro> findByNombreContaining(String mastname);
    //Contar alumnos de un maestro
    Maestro findByNombre(String mastname);

}
