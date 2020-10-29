package com.agibilibus.SIGET.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.agibilibus.SIGET.dao.ReunionDAO;
import com.agibilibus.SIGET.dao.UserDAO;

@Component
public class Manager {
	@Autowired
	private UserDAO userdao;
	@Autowired
	private ReunionDAO reuniondao;
	private Usuario user;
	private Calendario calendar;
	

	private ConcurrentHashMap<String, Usuario> connectedUsersByUserName;
	private ConcurrentHashMap<String, Usuario> connectedUsersByHttpSession;

	private Manager() {
		this.connectedUsersByUserName = new ConcurrentHashMap<>();
		this.connectedUsersByHttpSession = new ConcurrentHashMap<>();
		this.user = null;
		this.calendar = null;

	}

	private static class ManagerHolder {
		static Manager singleton = new Manager();
	}

	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}

	public Usuario login(HttpSession httpSession, String userName, String pwd) throws Exception {
		try {
			Optional<Usuario> optUser = userdao.findById(userName);

			if (optUser.isPresent()) {
				Usuario user = optUser.get();
				if (user.getPassword().equals(pwd)) {
					user.setHttpSession(httpSession);
					this.connectedUsersByUserName.put(userName, user);
					this.connectedUsersByHttpSession.put(httpSession.getId(), user);
					this.user = user;
					return user;
				}
			}
			throw new Exception("Credenciales inválidas");
		} catch (SQLException e) {
			throw new Exception("Credenciales inválidas");
		}
	}
	public JSONObject getSemana()throws Exception {
		if(user == null)
			throw new Exception("No hay usuario");
		
		if(calendar == null)
			calendar = new Calendario();
		
		return calendar.getSemana(user);
	}
	public JSONObject getSemanaSiguiente()throws Exception {
		if(user == null)
			throw new Exception("No hay usuario");
		
		if(calendar == null)
			calendar = new Calendario();
		
		return calendar.getSemanaSiguiente(user);
	}
	public JSONObject getSemanaAnterior()throws Exception {
		if(user == null)
			throw new Exception("No hay usuario");
		
		if(calendar == null)
			calendar = new Calendario();
		
		return calendar.getSemanaAnterior(user);
	}
	
	public void guardarReunion(int idReunion, String titulo, String descripcion, DateTime horaInicio, DateTime horaFin, Usuario organizador, String[] correosAsistentes, String url) throws Exception {
		List<Usuario> asistentes = new ArrayList<Usuario>();
		List<EstadoInvitacion> estados = new ArrayList<>();
		for (String asistente: correosAsistentes){
			Optional<Usuario> a = userdao.findById(asistente);
			if (a.isPresent()) {
				asistentes.add(a.get());
				estados.add(EstadoInvitacion.pendiente);
			}
		}
		Usuario or = userdao.findById(organizador.getUser()).get();
		reuniondao.save(new Reunion(idReunion, titulo, descripcion, horaInicio, horaFin, or, asistentes, estados, url));
	}
	
	public JSONObject getReuniones(Usuario u) {
		JSONArray jsaReuniones = new JSONArray();
		Usuario usuario = userdao.findById(u.getUser()).get();
		List<Reunion> reuniones = reuniondao.findAll();
		for (Reunion r : reuniones) {
			if (r.getOrganizador().getUser().equals(usuario.getUser()) || r.getAsistentes().contains(usuario))
				jsaReuniones.put(r.toJSON());
		}
		JSONObject jso = new JSONObject();
		jso.put("reuniones", jsaReuniones);
		return jso;
	}
	
	
	public void cargarCalendario () {
	}
	
	public void cargarReuniones() {
		
	}

	public void enviarInivitacion() {
	
		
	}

	public void mostrarNotificacion(Reunion reunion, List<Usuario> asistentes) {
		
		
	}

	public void responderInvitacion(Reunion reunion, Usuario asistente) {
		
		
	}


}
