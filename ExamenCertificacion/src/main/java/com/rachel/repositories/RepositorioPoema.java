package com.rachel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rachel.models.Poema;

public interface RepositorioPoema extends JpaRepository<Poema, Long> {

}
