package com.agibilibus.SIGET.model;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Document(collection = "roles")

public class Rol {
	@Id
	private String id;
	private String nombre;
	private List<Usuario> usuarios;

	public Rol() {
		this.id = "";
		this.nombre = "";
		usuarios = new LinkedList<>();
	}

	public Rol(String nombre) {
		this.nombre = nombre;
		usuarios = new LinkedList<>();
	}

	public Rol(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		usuarios = new LinkedList<>();
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean addUsuario(Usuario user) {
		return usuarios.add(user);
	}

	public boolean eliminarUsuario(Usuario user) {
		return usuarios.remove(user);
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public boolean contains(Usuario user) {
		return usuarios.contains(user);
	}

}
