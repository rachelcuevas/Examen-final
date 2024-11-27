package com.rachel.models;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @OneToMany(mappedBy = "creador") // Asegúrate de que 'creador' exista en Articulo
	  private Set<Poema> poema;

	@NotBlank(message = "Por favor proporciona tu nombre.")
	@Size(min = 3, message = "El nombre necesita tener al menos 3 caracteres.")
	private String nombre;
	
	@NotBlank(message = "Por favor proporciona tu apellido.")
	@Size(min = 3, message = "El apellido necesita tener al menos 3 caracteres.")
	private String apellido;
	
	@Column (unique = true)
	@NotBlank(message = "Por favor ingresa un correo valido.")
	@Size(min= 8, message = "El correo necesita tener al menos 8 caracteres.")
	private String email;
	
	@NotBlank(message = "Por favor ingresa una contraseña valida.")
	@Size(min= 8, message = "La contraseña necesita tener al menos 8 caracteres.")
	private String password;
	
	@Transient
	private String confirmarPassword;

	@OneToMany(mappedBy = "creador")
	private List<Poema>poemas;

	
	public Usuario() {
		super();
		this.id = 0l;
		this.nombre = "";
		this.apellido = "";
		this.email = "";
		this.password = "";
		this.confirmarPassword = "";
		this.poemas = null;
	}
	
	public Usuario(Long id, String nombre, String apellido, String email, String password, String confirmarPassword,
			List<Poema> poemas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.confirmarPassword = confirmarPassword;
		this.poemas = poemas;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public List<Poema> getArticulos() {
		return poemas;
	}

	public void setArticulos(List<Poema> poemas) {
		this.poemas = poemas;
	}
	
	
	
	
}
