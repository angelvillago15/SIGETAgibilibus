package com.agibilibus.SIGET.model;


import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.agibilibus.SIGET.dao.InvitacionDAO;
import com.agibilibus.SIGET.dao.UserDAO;

import lombok.Data;

@Component
@Data
@Document(collection = "invitaciones")

public class Invitacion {
	@Id
	private String idInvitacion;
	private Usuario usuario;
	private Reunion reunion;
	private EstadoInvitacion estado;

	@Autowired
	private InvitacionDAO invitaciondao;

	@Autowired
	private UserDAO userdao;

	public Invitacion() {
	}

	public Invitacion(Usuario usuario, Reunion reunion, EstadoInvitacion estado) {
		this.usuario = usuario;
		this.reunion = reunion;
		this.estado = estado;

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	public EstadoInvitacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoInvitacion estado) {
		this.estado = estado;
	}

	public void aceptarInvitacion() {
	}

	public void rechazarInvitacion() {
	}

	public JSONObject toJSON() {
		JSONObject jso = new JSONObject();
		jso.put("usuario", this.usuario.getNombre());
		jso.put("reunion", this.reunion.toJSON());
		jso.put("estado", this.estado);
		return jso;

	}

	private static class InvitacionHolder {
		static Invitacion singleton = new Invitacion();
	}

	@Bean(name = "beanInvitacion")
	public static Invitacion get() {
		return InvitacionHolder.singleton;
	}

	public void enviarInvitacion() {

	}

	public JSONArray recibirInvitacion(Usuario user) {
		JSONArray jsaInvitaciones = new JSONArray();

		List<Invitacion> invitaciones = invitaciondao.findAll();

		for (Invitacion inv : invitaciones) {
			if ((inv.getReunion().getAsistentes().contains(user)) && inv.getEstado() == EstadoInvitacion.pendiente) {
				jsaInvitaciones.put(inv.toJSON());
			}
		}
		return jsaInvitaciones;
	}

	public void responderInvitacion() {
	}

}
