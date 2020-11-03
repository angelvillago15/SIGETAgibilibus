package com.agibilibus.SIGET.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.json.JSONArray;
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
@Document(collection = "reuniones")
public class Reunion {
	@Id
	private String idReunion;
	private String titulo;
	private String descripcion;
	private DateTime horaInicio;
	private DateTime horaFin;
	private Usuario organizador;
	private List<Usuario> asistentes;
	private List<EstadoInvitacion> estadosInvitaciones;
	private String url;

	@Autowired
	private ReunionDAO reuniondao;

	@Autowired
	private UserDAO userdao;
	
	@Autowired
	private InvitacionDAO invitaciondao;

	public Reunion() {
	}

	public Reunion(String idReunion, String titulo, String descripcion, DateTime horaInicio, DateTime horaFin,
	        Usuario organizador, List<Usuario> asistentes, String url) {
		super();
		this.idReunion = idReunion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.organizador = organizador;
		this.asistentes = asistentes;
		this.url = url;
	}

	public String getIdReunion() {
		return idReunion;
	}

	public void setIdReunion(String idReunion) {
		this.idReunion = idReunion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public DateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(DateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public DateTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(DateTime horaFin) {
		this.horaFin = horaFin;
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}

	public List<Usuario> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<Usuario> asistentes) {
		this.asistentes = asistentes;
	}

	public List<EstadoInvitacion> getEstadosInvitaciones() {
		return estadosInvitaciones;
	}

	public void setEstadosInvitaciones(List<EstadoInvitacion> estadosInvitaciones) {
		this.estadosInvitaciones = estadosInvitaciones;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public JSONObject toJSON() {
		JSONObject jso = new JSONObject();
		JSONArray jsaAsistentes = new JSONArray();
		jso.put("id", this.idReunion);
		jso.put("title", this.titulo);
		jso.put("descripcion", this.descripcion);
		String horaInicio = this.horaInicio.toString().substring(11, 19);
		String fecha = this.horaInicio.toString().substring(0, 10);
		String horaFin = this.horaFin.toString().substring(11, 19);
		jso.put("fecha", fecha);
		jso.put("start", horaInicio);
		jso.put("end", horaFin);
		jso.put("organizador", this.organizador.toJSON());
		for (Usuario u : this.asistentes)
			jsaAsistentes.put(u.toJSON());
		jso.put("asistentes", jsaAsistentes);
		jso.put("url", this.url);
		return jso;
	}

	public JSONObject toEvent() {
		JSONObject jsoEvento = new JSONObject();
		jsoEvento.put("id", this.idReunion);
		jsoEvento.put("title", this.titulo);
		jsoEvento.put("start", this.horaInicio);
		jsoEvento.put("end", this.horaFin);
		return jsoEvento;
	}

	public void guardarReunion(String titulo, String descripcion, DateTime horaInicio, DateTime horaFin,
	        Usuario organizador, String[] correosAsistentes, String url) {
		List<Usuario> asist = new ArrayList<>();
		String id = organizador.getUser() + "#" + titulo + "#" + horaInicio.toString() + "#" + horaFin.toString();
		// Formato para guardar el id:
		// Organizador#Titulo#HoraInicio#HoraFin#Asistente1#Asistente2....
		for (String asistente : correosAsistentes) {
			Optional<Usuario> a = userdao.findByEmail(asistente);
			if (a.isPresent()) {
				asist.add(a.get());
				id += "#" + a.get().getUser();
			}
		}
		Optional<Usuario> optUser = userdao.findById(organizador.getUser());
		if (optUser.isPresent()) {
			Usuario or = optUser.get();
			Reunion r=new Reunion(id, titulo, descripcion, horaInicio, horaFin, or, asist, url);
			reuniondao.save(r);
			for(Usuario u:asist) {
				String idInv=r.getIdReunion()+u.getUser();
				invitaciondao.save(new Invitacion(idInv, u, r, EstadoInvitacion.pendiente));
			}
			
		}
	}

	public Reunion modificarReunion(Reunion r) {
		return null;
	}

	public void eliminarReunion(Reunion r) {
		reuniondao.delete(r);
	}

	public JSONArray getReuniones(Usuario u) {
		JSONArray jsaReuniones = new JSONArray();
		Optional<Usuario> optUser = userdao.findById(u.getUser());
		if (optUser.isPresent()) {
			Usuario usuario = optUser.get();
			List<Reunion> reuniones = reuniondao.findAll();
			for (Reunion r : reuniones) {
				if (r.getOrganizador().getUser().equals(usuario.getUser()) || r.getAsistentes().contains(usuario))
					jsaReuniones.put(r.toEvent());
			}
		}
		return jsaReuniones;
	}

	private static class ReunionHolder {
		static Reunion singleton = new Reunion();
	}

	@Bean(name = "beanReunion")
	public static Reunion get() {
		return ReunionHolder.singleton;
	}

	public JSONObject loadReunion(String id) {
		Optional<Reunion> reunion = reuniondao.findById(id);
		Reunion r = new Reunion();
		if (reunion.isPresent()) {
			r = reunion.get();
		}
		return r.toJSON();
	}

}
