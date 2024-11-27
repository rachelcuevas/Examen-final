package com.rachel.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Login {

	@Column (unique = true)
	@NotBlank(message = "Por favor ingresa un correo valido.")
	@Size(min= 8, message = "El correo necesita tener al menos 8 caracteres.")
	private String email;
	
	
	@NotBlank(message = "Por favor ingresa una contraseña valida.")
	@Size(min= 8, message = "La contraseña necesita tener al menos 8 caracteres.")
	private String password;

	
	public Login() {
		super();
		this.email = "";
		this.password = "";
	}
	
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	
	
}
