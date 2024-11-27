package com.rachel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rachel.models.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
	Usuario findByNombre(String nombre);

	Optional<Usuario> findByEmail(String email);
}
