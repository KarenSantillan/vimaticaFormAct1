package com.viamatica.santillank.controller;

import com.viamatica.santillank.entities.Alumno;
import com.viamatica.santillank.entities.Maestro;
import com.viamatica.santillank.entities.Materia;
import com.viamatica.santillank.services.AlumnoService;
import com.viamatica.santillank.services.MaestroService;
import com.viamatica.santillank.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

@Controller
public class CursoController {
    @Autowired
    AlumnoService alumnoService;
    @Autowired
    MaestroService maestroService;
    @Autowired
    MateriaService materiaService;

    @GetMapping("/buscarAlumno")
    public String buscarAlumnoNombre(@RequestParam("q") String name, Model model){
        List<Alumno> alu = alumnoService.buscarAlumnoNombre(name);
        model.addAttribute("resultados", alu);
        return "vista";
    }
    @GetMapping("/buscarMaestro")
    public String buscarMaestroNombre(@RequestParam("q") String name, Model model){
        List<Maestro> mast = maestroService.buscarMaestroNombre(name);
        model.addAttribute("resultados", mast);
        return "vista";
    }

    @GetMapping("/countAlumMast")
    public String countAlumnosByNombre(@RequestParam("q") String nombre, Model model) {
        Integer count = maestroService.countAlumByMaest(nombre);
        model.addAttribute("valor", count);
        return "vista";
    }

    @GetMapping("/bestPuntos")
    public String findAlumByMateriaOrderByPunt(@RequestParam("q") String nomMateria, @RequestParam("s") int n, Model model){
        List<Alumno> alumnosBest = alumnoService.findAlumByMateriaOrderByPunt(nomMateria, n);
        model.addAttribute("best", alumnosBest);
        return "vista";
    }

    @GetMapping("/bestMateria")
    public String findMateriaByPuntaje(@RequestParam("q") String estudiante, @RequestParam("s") int puntaje, Model model){
        Materia mat = materiaService.findMateriaByPuntaje(estudiante, puntaje);
        model.addAttribute("bestMat", mat);
        return "vista";
    }
}
