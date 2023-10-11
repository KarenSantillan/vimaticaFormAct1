package com.viamatica.santillank.services;

import com.viamatica.santillank.entities.Alumno;
import com.viamatica.santillank.repository.AlumnoRepository;
import com.viamatica.santillank.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    MateriaRepository materiaRepository;
    public List<Alumno> buscarAlumnoNombre(String nombre){
        return alumnoRepository.findByNombreContaining(nombre);
    }
    public List<Alumno> findAlumByMateriaOrderByPunt(String nomMateria, int n){
        return alumnoRepository.findAlumByMateriaOrderByPunt(nomMateria, n);
    }


}
