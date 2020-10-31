package com.agibilibus.SIGET.model;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agibilibus.SIGET.dao.ReunionDAO;
import com.agibilibus.SIGET.dao.UserDAO;

@Component
public class Manager {
	@Autowired
	private UserDAO userdao;
	private Usuario user;
	private Calendario calendar;
	private ReunionDAO reuniondao;

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

	public static Manager get() {
		return ManagerHolder.singleton;
	}

	public void guardarReunion(int idReunion, String titulo, String descripcion, DateTime horaInicio, DateTime horaFin,
	        Usuario organizador, List<Usuario> asistentes, String url) throws Exception {
		Reunion reunionNueva = new Reunion(idReunion, titulo, descripcion, horaInicio, horaFin, organizador, asistentes,
		        url);
		reuniondao.save(reunionNueva);
	}

	public void cargarCalendario() {
	}

	public void cargarReuniones() {

	}

	public void enviarInivitacion() {

	}

	public void mostrarNotificacion(Reunion reunion, List<Usuario> asistentes) {

	}

	public void responderInvitacion(Reunion reunion, Usuario asistente) {

	}

	public Usuario register(String pwd1, String nombreCompleto, String nombre, String apellidos, DateTime userDate,
	        String userDni, int userTelf, String email) {
		Usuario user = new Usuario();
		user.setNombre(nombreCompleto);
		user.setUser(nombre);
		user.setApellidos(apellidos);
		user.setDate(userDate);
		user.setDNI(userDni);
		user.setTelefono(userTelf);
		user.setEmail(email);
		user.setPassword(pwd1);

		return userdao.save(user);

	}

}
