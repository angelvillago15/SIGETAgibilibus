package com.agibilibus.SIGET.model;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.agibilibus.SIGET.dao.UserDAO;

import lombok.Data;

@Component
@Data
@Document(collection = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1446243385065996422L;
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

	@Autowired
	private UserDAO userdao;

	public Usuario() {
	}

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

	public Usuario register() {
		return userdao.save(this);
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

	public Usuario crearUsuario(String pwd1, String nombreCompleto, String nombre, String apellidos, DateTime userDate,
	        String userDni, int userTelf, String email) {
		Usuario user;
		user = new Usuario(nombre, pwd1, nombreCompleto, apellidos, userTelf, email, userDni, userDate, "usuario");

		return userdao.save(user);
	}

	public Usuario modificarUsuario(Usuario u) {
		return null;
	}

	public void eliminarUsuario(Usuario u) {

	}

	private static class UsuarioHolder {
		static Usuario singleton = new Usuario();
	}

	@Bean(name = "beanUsuario")
	public static Usuario get() {
		return UsuarioHolder.singleton;
	}
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if (this.getClass() != obj.getClass())
		    return false;

		return ((Usuario)obj).getNombre().equals(this.nombre);
	}
}
