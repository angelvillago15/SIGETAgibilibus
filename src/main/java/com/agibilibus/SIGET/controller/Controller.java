package com.agibilibus.SIGET.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.agibilibus.SIGET.model.Manager;
import com.agibilibus.SIGET.model.Reunion;
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
		System.out.println("primera reunion");
		JSONObject jso = new JSONObject(datosReunion);
		String titulo = jso.getString("nombre");
		String descripcion = jso.getString("descripcion");
		//DateTime horaI = jso.get
		//DateTime horaF = jso.get
		Usuario organizador = (Usuario) session.getAttribute("user");
		String url = jso.getString("url");
		Reunion reunionNueva = Manager.get().guardarReunion(0, titulo, descripcion, new DateTime(2020,10,30,10,30,DateTimeZone.forID("UTC")),new DateTime(2020,10,30,11,30,DateTimeZone.forID("UTC")), organizador, null, url);
	}
	
	
}
