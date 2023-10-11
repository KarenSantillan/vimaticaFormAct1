package com.viamatica.santillank.services;

import com.viamatica.santillank.entities.Materia;
import com.viamatica.santillank.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {
    @Autowired
    MateriaRepository materiaRepository;
    public Materia findMateriaByPuntaje(String estudiante, int puntaje){
        return materiaRepository.findMateriaByPuntaje(estudiante, puntaje);
    }
}
