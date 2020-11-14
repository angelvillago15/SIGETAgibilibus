package com.agibilibus.SIGET;

import static org.junit.Assert.*;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.model.Invitacion;
import com.agibilibus.SIGET.model.Reunion;

@RunWith(SpringRunner.class)
@SpringBootTest

class InvitacionTest {

	@Autowired
	private HttpSession sesion;

	private Reunion r = new Reunion();
	private Invitacion inv = new Invitacion();
	
	Controller controller = new Controller();
	JSONObject credenciales1 = new JSONObject();
	JSONObject datosReunion = new JSONObject();
	JSONObject credenciales2 = new JSONObject();

	@Test
	void TestCrearInvitacion() {

		try {
			credenciales1.put("userName",  "Elisa");
			credenciales1.put("pwd", "Seguridad2020");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			fail();
		}

		try {
			controller.login(sesion, (Map<String, Object>) credenciales1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
		
		try {
			datosReunion.put("nombre", "graduacion");
			datosReunion.put("fecha", "23/01/2021");
			datosReunion.put("horaInicio", "10:00:00");
			datosReunion.put("horaFin", "12:00:00");
			datosReunion.put("descripcion", "graduacion");
			datosReunion.put("url", "");
			datosReunion.put("correos", "jaime@jaime.com");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			fail();
		}

		try {
			controller.guardarReunion(sesion, (Map<String, Object>) datosReunion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
		
		
	}
	
	@Test
	void TestRecibirInvitacion() {
	
	
	try {
		credenciales2.put("userName",  "Jaime");
		credenciales2.put("pwd", "Seguridad2020");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		fail();
	}

	try {
		controller.login(sesion, (Map<String, Object>) credenciales2);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		fail();
	}
	
	String str = controller.getInvitaciones(sesion);
	JSONObject jso;
	try {
		jso = new JSONObject(str);
		JSONArray jsa = (JSONArray) jso.get("invitaciones");
		
		for(int i=0;i<jsa.length();i++) {
			JSONObject o = (JSONObject) jsa.get(i);
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		fail();
	}
	}
	
	
	

	
}


