package com.rachel.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "poemas")
public class Poema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Por favor proporciona el título.")
    @Size(min = 5, message = "El título debe tener al menos 5 caracteres.")
    private String titulo;

    @NotBlank(message = "Por favor proporciona el autor.")
    @Size(min = 3, message = "El autor debe tener al menos 3 caracteres.")
    private String autor;

    @NotNull(message = "Por favor proporciona el año.")
    @Min(value = 0, message = "El año debe ser un número positivo.")
    private Long año;

    @NotBlank(message = "Por favor proporciona la letra del poema.")
    @Size(min = 15, message = "La letra del poema debe tener al menos 15 caracteres.") 
    private String letra;

	public Poema(){
		super();
		this.id =  1L;
		this.titulo = "";
		this.autor = "";
		this.año = 0L;
		this.letra = "";
	}
	
	public Poema(Long id, String titulo, String autor, String categoria, Long año, String Letra){
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.año = año;
		this.letra= letra;
	}

	@ManyToOne
	    @JoinColumn(name = "usuario_id") // Nombre de la columna en la base de datos
	    private Usuario creador; // Esta es la propiedad que se está buscando

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Long getAño() {
		return año;
	}

	public void setAño(Long año) {
		this.año = año;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {   
	    this.letra = letra;  
	}
	

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	
	
	
}
