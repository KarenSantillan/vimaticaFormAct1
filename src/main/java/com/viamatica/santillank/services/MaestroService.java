package com.viamatica.santillank.services;

import com.viamatica.santillank.entities.Alumno;
import com.viamatica.santillank.entities.Maestro;
import com.viamatica.santillank.repository.MaestroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaestroService {
    @Autowired
    MaestroRepository maestroRepository;
    //Buscar maestro por nombre
    public List<Maestro> buscarMaestroNombre(String nombre){
        return maestroRepository.findByNombreContaining(nombre);
    }
    //Cuantos alumnos tiene un maestro
    @Transactional
    public Integer countAlumByMaest(String nombre){
        Maestro idMaes = maestroRepository.findByNombre(nombre);
        Integer count = idMaes.getAlumnosByIdMaestro().size();
        return count;
    }
}
