package com.rachel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.rachel.models.Poema;
import com.rachel.repositories.RepositorioPoema;

@Service
public class ServicioPoemas {

    @Autowired
    private RepositorioPoema repositorio;

    public Poema crear(Poema poema) {
        return repositorio.save(poema);
    }

    public void validarPoema(BindingResult validaciones, Poema poema) {
        // Aquí puedes agregar validaciones adicionales si es necesario
        if (poema.getTitulo() == null || poema.getTitulo().isEmpty()) {
            validaciones.rejectValue("titulo", "error.titulo", "El título es obligatorio.");
        }
        // Agregar más validaciones según sea necesario
    }

    public List<Poema> obtenerTodas() {
        return repositorio.findAll();
    }

    public Poema obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public void eliminarPorId(Long id) {
        repositorio.deleteById(id);
    }

    public void actualizar(Poema poema) {
        repositorio.save(poema);
    }
}