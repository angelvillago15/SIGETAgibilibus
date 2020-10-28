package com.agibilibus.SIGET.model;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.servlet.http.HttpSession;

import lombok.Data;

@Data
@Document(collection = "usuarios")
public class Usuario implements Serializable {

	@Id
	private String user;
	private String password;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String email;
	private String dni;
	private DateTime nacimiento;
	private String rol;
	@Transient
	private HttpSession httpSession;
	
	public Usuario() {}

	public Usuario(String user, String password, String nombre, String apellidos, int telefono, String email,
	        String dni, DateTime nacimiento, String rol) {
		super();
		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
		this.nacimiento = nacimiento;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDNI() {
		return dni;
	}

	public void setDNI(String dNI) {
		dni = dNI;
	}

	public DateTime getDate() {
		return nacimiento;
	}

	public void setDate(DateTime date) {
		this.nacimiento = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}

	public HttpSession getHttpSession() {
		return httpSession;
	}

	public JSONObject toJSON() {
		JSONObject jso = new JSONObject();
		jso.put("nombre", this.nombre);
		jso.put("apellidos", this.apellidos);
		jso.put("telefono", this.telefono);
		jso.put("email", this.email);
		jso.put("dni", this.dni);
		jso.put("nacimiento", this.nacimiento);
		jso.put("user", this.user);
		jso.put("password", this.password);
		jso.put("rol", this.rol);
		return jso;

	}
}