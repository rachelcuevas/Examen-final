package com.rachel.services;  

import java.util.List;  
import org.mindrot.jbcrypt.BCrypt;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.validation.BindingResult;  
import com.rachel.models.Login;  
import com.rachel.models.Usuario;  
import com.rachel.repositories.RepositorioUsuario;  

@Service  
public class ServicioUsuarios {  
    
    @Autowired  
    private RepositorioUsuario repositorio;  
    
    // CRUD  
    public Usuario crear(Usuario usuario) {  
        String hashPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());  
        usuario.setPassword(hashPassword);  
        return this.repositorio.save(usuario);  
    }  

    public List<Usuario> obtenerTodos() {  
        return (List<Usuario>) this.repositorio.findAll();  
    }  

    public Usuario obtenerPorId(Long id) {  
        return this.repositorio.findById(id).orElse(null);  
    }  
    
    public Usuario obtenerPorEmail(String email) {  
        return this.repositorio.findByEmail(email).orElse(null);  
    }  
    
    public void eliminarPorId(Long id) {  
        this.repositorio.deleteById(id);  
    }  
    
    public BindingResult validarLogin(BindingResult validaciones, Login login) {  
        Usuario usuarioDb = this.obtenerPorEmail(login.getEmail());  
        if (usuarioDb == null) {  
            validaciones.rejectValue("email", "emailNoRegistrado",  
                    "El email ingresado no se encuentra en la base de datos.");  
        } else {  
            if (!BCrypt.checkpw(login.getPassword(), usuarioDb.getPassword())) {  
                validaciones.rejectValue("password", "passwordIncorrecta",  
                        "Contraseña Incorrecta.");  
            }  
        }  
        return validaciones;  
    }  
    
    public void validarRegistro(BindingResult validaciones, Usuario usuario) {  
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {  
            validaciones.rejectValue("email", "error.usuario", "El email es obligatorio.");  
        }  
        
        // Verificar si el usuario ya existe  
        if (this.obtenerPorEmail(usuario.getEmail()) != null) {  
            validaciones.rejectValue("email", "emailYaRegistrado", "El email ya está registrado.");  
        }  
        
       
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {  
            validaciones.rejectValue("nombre", "error.usuario", "El nombre es obligatorio.");  
        }  
        
       
    }  
}