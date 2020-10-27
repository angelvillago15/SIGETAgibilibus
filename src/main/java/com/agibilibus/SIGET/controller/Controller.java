package com.agibilibus.SIGET.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.agibilibus.SIGET.model.Manager;
import com.agibilibus.SIGET.model.Usuario;

@RestController
public class Controller {

	@PostMapping("/login")
	public void login(HttpSession session, @RequestBody Map<String, Object> credenciales) throws Exception {
		JSONObject jso = new JSONObject(credenciales);
		String userName = jso.getString("userName");
		String pwd = jso.getString("pwd");
		Usuario user = Manager.get().login(session, userName, pwd);
		session.setAttribute("user", user);
		Usuario usuario = (Usuario) session.getAttribute("user");
	}
	

	@PostMapping("/getSemana")
	public String getSemana(HttpSession session ) throws Exception {
		return Manager.get().getSemana().toString();

	}
	@PostMapping("/getSemanaSiguiente")
	public String getSemanaSiguiente(HttpSession session ) throws Exception {
		JSONObject jso = Manager.get().getSemanaSiguiente();
		return jso.toString();

	}
	@PostMapping("/getSemanaAnterior")
	public String getSemanaAnterior(HttpSession session ) throws Exception {
		return Manager.get().getSemanaAnterior().toString();

	}

	@PostMapping("/nuevaTarea")
	public void guardarReunion(HttpSession session, @RequestBody Map<String, Object> datosReunion) throws Exception {
		JSONObject jso = new JSONObject(datosReunion);
		String titulo = jso.getString("nombre");
		String descripcion = jso.getString("descripcion");
		String [] fecha = jso.getString("fecha").split("-");
		String [] horaIni = jso.getString("horaInicio").split(":");
		String [] horaFin = jso.getString("horaFin").split(":");
		DateTime horaI = new DateTime(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[2]),Integer.parseInt(horaIni[0]),Integer.parseInt(horaIni[1]),DateTimeZone.forID("UTC"));
		DateTime horaF = new DateTime(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[2]),Integer.parseInt(horaFin[0]),Integer.parseInt(horaFin[1]),DateTimeZone.forID("UTC"));
		Usuario organizador = (Usuario) session.getAttribute("user");
		String url = jso.getString("url");
		String[] correosAsistentes = ((jso.getString("correos")).replace(" ", "")).split(","); 
		Manager.get().guardarReunion(((int) (Math.random()*(1000000)+1)), titulo, descripcion, horaI,horaF, organizador, correosAsistentes, url);
		
	}
	
	@PostMapping("/getReuniones")
	public String getReuniones(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("user");
		return Manager.get().getReuniones(usuario).toString();
	}
	
	
}
