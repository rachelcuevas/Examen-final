package com.rachel.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.rachel.models.Poema;
import com.rachel.services.ServicioPoemas;
import com.rachel.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorPoemas {

    @Autowired
    private ServicioPoemas servicio;

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping("/poemas") // Mostrar todos los poemas
    public String mostrarPoemas(HttpSession sesion, Model modelo) {
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        List<Poema> poemas = this.servicio.obtenerTodas();
        modelo.addAttribute("poemas", poemas);
        modelo.addAttribute("nombreCompleto", sesion.getAttribute("nombreCompleto")); // Agregar nombre completo
        return "poema.jsp";
    }

    @GetMapping("/form/agregar") 
    public String agregar(HttpSession sesion, Model modelo) {
        if (sesion.getAttribute("nombreCompleto") == null) {
            return "redirect:/";
        }
        modelo.addAttribute("poema", new Poema());
        return "agregarPoema.jsp";
    }

    @GetMapping("/form/editar/{id}") // Vista de form de edición
    public String editar(@PathVariable("id") Long id, HttpSession sesion, Model modelo) {
        if (sesion.getAttribute("nombreCompleto") == null) {
            return "redirect:/";
        }
        modelo.addAttribute("poema", this.servicio.obtenerPorId(id));
        return "editarPoema.jsp";
    }

    @PostMapping("/guardar") // Procesar form de creación
    public String guardar(HttpSession sesion, @Valid @ModelAttribute("poema") Poema poema, BindingResult validaciones) {
        if (sesion.getAttribute("nombreCompleto") == null) {
            return "redirect:/";
        }
        this.servicio.validarPoema(validaciones, poema);
        if (validaciones.hasErrors()) {
            return "agregarPoema.jsp";
        }
        poema.setCreador(servicioUsuarios.obtenerPorId((Long) sesion.getAttribute("idUsuario"))); // Asignar creador
        this.servicio.crear(poema);
        return "redirect:/poemas"; // Redirigir a poemas
    }

    @PutMapping("/actualizar/{id}") // Procesar form de edición
    public String actualizar(@PathVariable("id") Long id, HttpSession sesion,
            @Valid @ModelAttribute("poema") Poema poema, BindingResult validaciones) {
        if (sesion.getAttribute("nombreCompleto") == null) {
            return "redirect:/";
        }
        this.servicio.validarPoema(validaciones, poema);
        if (validaciones.hasErrors()) {
            return "editarPoema.jsp";
        }
        this.servicio.actualizar(poema);
        return "redirect:/poemas";
    }

    @DeleteMapping("/eliminar/{id}") // Eliminar un poema
    public String eliminar(@PathVariable("id") Long id, HttpSession sesion) {
        if (sesion.getAttribute("nombreCompleto") == null) {
            return "redirect:/";
        }
        this.servicio.eliminarPorId(id);
        return "redirect:/poemas";
    }

    @GetMapping("/detalle/{id}") // Vista de detalle
    public String detalle(@PathVariable("id") Long id, HttpSession sesion, Model modelo) {
        if (sesion.getAttribute("nombreCompleto") == null) {
            return "redirect:/";
        }
        modelo.addAttribute("poema", this.servicio.obtenerPorId(id));
        return "detalle.jsp";
    }
}