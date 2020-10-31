package com.agibilibus.SIGET.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.agibilibus.SIGET.model.Manager;
import com.agibilibus.SIGET.model.Sesion;

@RestController
public class Controller {



	@PostMapping("/login")
	public void login(HttpSession session, @RequestBody Map<String, Object> credenciales) throws Exception {
		JSONObject jso = new JSONObject(credenciales);
		String userName = jso.getString("userName");
		String pwd = jso.getString("pwd");
		Sesion.get().login(session, userName, pwd);
		
	}
	
	@PostMapping("/register")
	public String register(HttpSession session, @RequestBody Map<String, Object> credenciales){
		JSONObject jso = new JSONObject(credenciales);
		JSONObject resultado = new JSONObject();
		boolean error = false;
		String message ="";
		
		String userName = jso.getString("userName");
		String userMail1 = jso.getString("userMail1");
		String userMail2 = jso.getString("userMail2");
		String pwd1 = jso.getString("pwd1");
		String pwd2 = jso.getString("pwd2");
		
		String userDate = jso.getString("userDate");
		String strTelf = jso.getString("userTelf");
		int userTelf=0;
		DateTime dt = new DateTime();
		
		if(userName.isEmpty()) {
			error = true;
			message += "Falta el nombre de usuario.\n";
		}
		if(!pwd1.equals(pwd2)) {
			error = true;
			message += "Las contraseñas no coinciden.\n";
		}
		if(!userMail1.equals(userMail2)) {
			error = true;
			message += "Los correos no coinciden.\n";
		}
		if(!strTelf.isEmpty()) {
			try {
				userTelf = Integer.parseInt(jso.getString("userTelf"));
			}
			catch(NumberFormatException e) {
				error = true;
				message += "Error en el formato del telefono.\n";
			}
		}
		
		if(!userDate.isEmpty()) {
			try {
				DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
				dt = formatter.parseDateTime(userDate);
				
			}catch(Exception e) {
				error = true;
				message += "Error en el formato de la fecha.\n";
			}
		}
		
		if(error) {
			resultado.put("type", error);
			resultado.put(message, message);
			return resultado.toString();
		}
		
		String userCompletName = jso.getString("userCompletName");
		String userApellidos = jso.getString("userApellidos");
		String userDni = jso.getString("userDni");
		
		try {
				Manager.get().register(pwd1, userCompletName, userName, userApellidos, dt, userDni, userTelf, userMail1);
				resultado.put("type", "OK");
		}
		catch (Exception e) {
				resultado.put("type", error);
				resultado.put(message, e.getMessage());
		}
		return resultado.toString();
	}


	
	

	
	

	
	
}
