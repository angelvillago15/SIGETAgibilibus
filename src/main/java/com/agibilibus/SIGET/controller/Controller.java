package com.agibilibus.SIGET.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
	}
	
	@PostMapping("/guardarReunion")
	public void guardarReunion(HttpSession session, @RequestBody Map<String, Object> datosReunion) throws Exception {
		
		
	}
	
	
}
