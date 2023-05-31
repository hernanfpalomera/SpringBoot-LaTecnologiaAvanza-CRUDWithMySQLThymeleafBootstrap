package com.app.web.Controler;


import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudianteControlador {

    EstudianteServicio estudianteServicio;

    public EstudianteControlador(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

    @GetMapping({"/estudiantes","/"})
    public String listarEstudiantes(Model modelo){
        modelo.addAttribute("estudiantes", estudianteServicio.listarTodosLosEstudiantes());
        return "estudiantes";
    }

    @GetMapping({"/estudiantes/nuevo"})
    public String mostrarFormularioDeRegistroEstudiante(Model modelo){
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("estudiante", estudianteServicio.obtenerEstudiantePorId(id));
        return "editar_estudiante";
    }

    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id,@ModelAttribute Estudiante estudiante, Model model){
        Estudiante estudianteExistente = estudianteServicio.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());

        estudianteServicio.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        estudianteServicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
