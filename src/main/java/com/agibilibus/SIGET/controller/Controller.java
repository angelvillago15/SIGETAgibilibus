package com.agibilibus.SIGET.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Sesion;
import com.agibilibus.SIGET.model.Usuario;

@RestController
public class Controller {
	private static String error = "error";
	private static String message = "message";

	@PostMapping("/login")
	public void login(HttpSession session, @RequestBody Map<String, Object> credenciales) throws Exception {
		try {
			JSONObject jso = new JSONObject(credenciales);
			String userName = jso.getString("userName");
			String pwd = jso.getString("pwd");
			Sesion.get().login(session, userName, pwd);
		} catch (Exception e) {
			throw new Exception(e);

		}
	}

	@PostMapping("/register")
	public String register(HttpSession session, @RequestBody Map<String, Object> credenciales) {
		JSONObject jso = new JSONObject(credenciales);
		String userCompletName = jso.getString("userCompletName");
		String userName = jso.getString("userName");
		String userApellidos = jso.getString("userApellidos");
		String userDate = jso.getString("userDate");
		String userDni = jso.getString("userDni");
		int userTelf = Integer.parseInt(jso.getString("userTelf"));
		String userMail = jso.getString("userMail");
		String pwd1 = jso.getString("pwd1");
		String pwd2 = jso.getString("pwd2");

		DateTime fecha = DateTime.parse(userDate);
		// DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		// DateTime dt = formatter.parseDateTime(userDate);

		JSONObject resultado = new JSONObject();

		if (pwd1.equals(pwd2)) {
			try {

				// Usuario user = new
				// Usuario(userName,pwd1,userCompletName,userApellidos,userTelf,userMail,userDni,fecha,"usuario"
				// );
				// user.register();

				Usuario.get().crearUsuario(pwd1, userCompletName, userName, userApellidos, fecha, userDni, userTelf,
				        userMail);

				resultado.put("type", "OK");
			} catch (Exception e) {
				resultado.put("type", error);
				resultado.put(message, e.getMessage());
			}
		} else {
			resultado.put("type", error);
			resultado.put(message, "las password no coinciden.");
		}

		return resultado.toString();
	}

	@PostMapping("/nuevaTarea")
	public void guardarReunion(HttpSession session, @RequestBody Map<String, Object> datosReunion) throws Exception {
		JSONObject jso = new JSONObject(datosReunion);
		String titulo = jso.getString("nombre");
		String descripcion = jso.getString("descripcion");
		String[] fecha = jso.getString("fecha").split("-");
		String[] horaIni = jso.getString("horaInicio").split(":");
		String[] horaFin = jso.getString("horaFin").split(":");
		DateTime horaI = new DateTime(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]),
		        Integer.parseInt(fecha[2]), Integer.parseInt(horaIni[0]), Integer.parseInt(horaIni[1]),
		        DateTimeZone.forID("UTC"));
		DateTime horaF = new DateTime(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]),
		        Integer.parseInt(fecha[2]), Integer.parseInt(horaFin[0]), Integer.parseInt(horaFin[1]),
		        DateTimeZone.forID("UTC"));
		Usuario organizador = (Usuario) session.getAttribute("user");
		String url = jso.getString("url");
		String[] correosAsistentes = ((jso.getString("correos")).replace(" ", "")).split(",");
		Reunion.get().guardarReunion(((int) (Math.random() * (1000000) + 1)), titulo, descripcion, horaI, horaF,
		        organizador, correosAsistentes, url);

	}
	
	@PostMapping("/getReuniones")
	public String getReuniones(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("user");
		return Reunion.get().getReuniones(usuario).toString();
	}

}
