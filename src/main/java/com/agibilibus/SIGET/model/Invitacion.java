package com.agibilibus.SIGET.model;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.agibilibus.SIGET.dao.InvitacionDAO;
import com.agibilibus.SIGET.dao.ReunionDAO;
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
	private ReunionDAO reuniondao;

	@Autowired
	private UserDAO userdao;

	public Invitacion() {
	}

	public Invitacion(String idInvitacion, Usuario usuario, Reunion reunion, EstadoInvitacion estado) {
		this.idInvitacion = idInvitacion;
		this.usuario = usuario;
		this.reunion = reunion;
		this.estado = estado;

	}

	public String getIdInvitacion() {
		return idInvitacion;
	}

	public void setIdInvitacion(String idInvitacion) {
		this.idInvitacion = idInvitacion;
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

	public JSONObject toJSON() {
		JSONObject jso = new JSONObject();
		jso.put("id", getIdInvitacion());
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

	public void responderInvitacion(Usuario user, String idInv, boolean opcion) throws Exception {
		Optional<Invitacion> optInv = invitaciondao.findById(idInv);

		if (optInv.isPresent()) {
			Invitacion inv = optInv.get();

			Optional<Reunion> optReunion = reuniondao.findById(inv.getReunion().getIdReunion());
			if (optReunion.isPresent()) {
				Reunion reunion = optReunion.get();

				if (opcion) {
					inv.setEstado(EstadoInvitacion.aceptado);
					reunion.getAsistentes().add(user);
					reuniondao.save(reunion);
				} else {
					inv.setEstado(EstadoInvitacion.rechazado);
				}
				invitaciondao.save(inv);
				
			}
			else
				throw new Exception("Error al cargar la reunión de le invitación");
		} else
			throw new Exception("La invitación no existe");
	}

	public void enviarInivitacion(String id, String[] correosAsistentes) {
		Optional<Reunion> optReunion = reuniondao.findById(id);
		String idInv = "";
		List<Usuario> asist = new ArrayList<>();
		if (optReunion.isPresent()) {
			Reunion r = optReunion.get();
			for (String correo : correosAsistentes) {
				Optional<Usuario> a = userdao.findByEmail(correo);
				if (a.isPresent()) {
					Usuario usuario = a.get();
					if (!r.getAsistentes().contains(usuario)) {
						asist.add(usuario);
						idInv = r.getIdReunion() + usuario.getUser();
						invitaciondao.save(new Invitacion(idInv, usuario, r, EstadoInvitacion.pendiente));
					}
				}
			}
			List<Usuario> asistReunion = r.getAsistentes();
			asistReunion.addAll(asist);

			r.setAsistentes(asistReunion);
			reuniondao.save(r);

		}
	}
	
	public void eliminarInvitacion(Invitacion invitacion) {
		Optional <Invitacion> optInv = invitaciondao.findById(invitacion.getIdInvitacion());
		if(optInv.isPresent()) 
			invitaciondao.deleteById(optInv.get().getIdInvitacion());
	}
	
	public void eliminarTodasInvitacionesUsuario (Usuario usuario) {
		List<Invitacion> invitaciones = invitaciondao.findAll();
		if (!invitaciones.isEmpty())
			for (Invitacion i : invitaciones)
				if (i.getUsuario().getUser().equals(usuario.getUser()))
					eliminarInvitacion(i);
	}
	
	public Invitacion getInvitacion(Reunion reunion, Usuario usuario) {
		List<Invitacion> listaInvitaciones = invitaciondao.findAll();
		for (Invitacion i : listaInvitaciones) {
			if(i.getReunion().getIdReunion().equals(reunion.getIdReunion())&&i.getUsuario().getUser().equals(usuario.getUser()))
				return i;
		}
		return null;
	}

}
