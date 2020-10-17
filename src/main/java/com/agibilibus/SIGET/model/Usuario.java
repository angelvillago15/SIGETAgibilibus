package com.agibilibus.SIGET.model;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "usuarios")
public class Usuario {

	@Id
	private String User;
	private String Nombre;
	private String Apellidos;
	private int Telefono;
	private String email;
	private String DNI;
	private String date;
	private String Password;
	private Rol rol;

	public Usuario(String nombre, String apellidos, int telefono, String email, String dNI, String nacimiento,
	        String user, String password, Rol rol) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		Telefono = telefono;
		this.email = email;
		DNI = dNI;
		this.date = nacimiento; // calendar1.get(Calendar.DATE);
		User = user;
		Password = password;
		this.rol = rol;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(String nombre_Rol) {
		if (nombre_Rol.equals("Admin"))
			this.rol = rol.ADMIN;
		else
			this.rol = rol.USUARIO;
	}

	public JSONObject toJSON() {
		JSONObject jso = new JSONObject();
		jso.put("nombre", this.Nombre);
		jso.put("apellidos", this.Apellidos);
		jso.put("telefono", this.Telefono);
		jso.put("email", this.email);
		jso.put("dni", this.DNI);
		jso.put("nacimiento", this.date);
		jso.put("user", this.User);
		jso.put("password", this.Password);
		jso.put("rol", this.rol);
		return jso;

	}
}