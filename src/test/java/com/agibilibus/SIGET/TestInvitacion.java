package com.agibilibus.SIGET;

import static org.junit.Assert.*;

import java.util.HashMap;
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

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestInvitacion {

	@Autowired
	private HttpSession sesion;

	private Controller controller = new Controller();
	private Map<String, Object> datosReunion = new HashMap<String, Object>();
	private Map<String, Object> datosInvitacion1 = new HashMap<String, Object>();
	private Map<String, Object> datosInvitacion2 = new HashMap<String, Object>();
	private Map<String, Object> credenciales1 = new HashMap<String, Object>();
	private Map<String, Object> credenciales2 = new HashMap<String, Object>();
	private String nombreTest = "Reunion";

	@Test
	public void TestCrearYEnviarInvitacion() {

		credenciales1.put("userName", "Elisa");
		credenciales1.put("pwd", "Seguridad2020");

		try {
			controller.login(sesion, credenciales1);
		} catch (Exception e) {
			fail();

		}

		datosReunion.put("nombre", nombreTest);
		datosReunion.put("fecha", "2020-12-01");
		datosReunion.put("horaInicio", "10:00:00");
		datosReunion.put("horaFin", "12:00:00");
		datosReunion.put("descripcion", "test");
		datosReunion.put("url", "https://www.youtube.com/?hl=es&gl=ES");
		datosReunion.put("correos", "jaime@jaime.com");

		try {
			controller.guardarReunion(sesion, datosReunion);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void TestRecibirInvitacion() {

		try {
			controller.login(sesion, (Map<String, Object>) credenciales2);
		} catch (Exception e) {

			fail();
		}

		String invitaciones = controller.getInvitaciones(sesion);
		JSONObject jso = null;

		try {
			jso = new JSONObject(invitaciones);
		} catch (JSONException e) {
	
			fail();
		}
		try {
			JSONArray jsa = (JSONArray) jso.get("invitaciones");
			boolean flag = false;
			for (int i = 0; i < jsa.length(); i++) {
				JSONObject invitacion = (JSONObject) jsa.get(i);
				JSONObject reunion = (JSONObject) invitacion.get("reunion");

				if (reunion.get("title").equals(nombreTest)) {
					flag = true;
				}

			}

			assertTrue(flag);

		} catch (JSONException e) {

			fail();
		}

	}
	
	@Test
	public void TestResponderInvitacion() {

		try {
			controller.login(sesion, (Map<String, Object>) credenciales1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
		
		datosInvitacion1.put("idInv", 0);
		datosInvitacion1.put("opcion", true);
		
		datosInvitacion2.put("idInv", 1);
		datosInvitacion2.put("opcion", false);

		try {
			controller.responderInvitacion(sesion, datosInvitacion1);
		} catch (Exception e) {

			fail();
		}
		
		try {
			controller.responderInvitacion(sesion, datosInvitacion2);
		} catch (Exception e) {

			fail();
		}

	}

}
