package com.rachel.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rachel.models.Login;
import com.rachel.models.Usuario;
import com.rachel.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {

    @Autowired
    private ServicioUsuarios servicio;

    @GetMapping("/") 
    public String formLogin(Model modelo) {
        modelo.addAttribute("loginUsuario", new Login());
        return "login.jsp";
    }

    @GetMapping("/registro") 
    public String formRegistro(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "register.jsp";
    }

    @GetMapping("/logout") 
    public String logOut(HttpSession sesion) {
        sesion.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login") 
    public String logIn(@Valid @ModelAttribute("loginUsuario") Login login, BindingResult validaciones,
            Model modelo, HttpSession sesion) {
        this.servicio.validarLogin(validaciones, login);
        if (validaciones.hasErrors()) {
            return "login.jsp";
        }
        Usuario usuario = this.servicio.obtenerPorEmail(login.getEmail());
        sesion.setAttribute("nombreCompleto", usuario.getNombre() + " " + usuario.getApellido());
        sesion.setAttribute("idUsuario", usuario.getId());
        return "redirect:/poemas"; // 
    }

    @PostMapping("/register") 
    public String register(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult validaciones, Model modelo,
            HttpSession sesion) {
        this.servicio.validarRegistro(validaciones, usuario);
        if (validaciones.hasErrors()) {
            return "register.jsp";
        }
        Usuario usuario2 = this.servicio.crear(usuario);
        sesion.setAttribute("nombreCompleto", usuario2.getNombre() + " " + usuario2.getApellido());
        sesion.setAttribute("idUsuario", usuario2.getId());
        return "redirect:/poemas"; // 
    }
}