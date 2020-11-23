package com.agibilibus.siget;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.siget.controller.Controller;
import com.agibilibus.siget.dao.UserDAO;
import com.agibilibus.siget.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestInvitacion {

	@Autowired
	private MockHttpSession session;
	@Autowired
	private UserDAO userdao;

	private Controller controller = new Controller();
	private String nombreTest = "TestInvitaciones2";

	@Test
	public void TestCrearYEnviarInvitacion() {
		// me logueo como Elisa
		session = new MockHttpSession();
		Usuario u = userdao.findById("Elisa").get();
		session.setAttribute("user", u);

		// creo una reunion
		Map<String, Object> reunion = new HashMap<String, Object>();
		reunion.put("nombre", nombreTest);
		reunion.put("descripcion", "Hola");
		reunion.put("fecha", "2020-10-01");
		reunion.put("horaInicio", "11:00:00");
		reunion.put("horaFin", "13:00:00");
		reunion.put("url", "https://www.google.com/");
		reunion.put("correos", "jaime@jaime.com, pepe");
		try {

			controller.guardarReunion(session, reunion);

		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void TestRecibiryAceptarInvitacion() {
		// me logueo como jaime
		Usuario u = userdao.findById("jaime").get();
		session.setAttribute("user", u);
		String idInvitacion = "";

		// cojo mis invitaciones
		String invitaciones = controller.getInvitaciones(session);

		JSONObject jso = null;
		try {
			jso = new JSONObject(invitaciones);

		} catch (JSONException e) {
			fail("Error en getInvitaciones.");
		}

		// busco la invitacion de Elisa a la nueva reunion

		try {
			JSONArray jsa = (JSONArray) jso.get("invitaciones");
			boolean flag = false;

			for (int i = 0; i < jsa.length() && !flag; i++) {
				JSONObject invitacion = (JSONObject) jsa.get(i);
				JSONObject reunion = (JSONObject) invitacion.get("reunion");

				if (reunion.get("title").equals(nombreTest)) {
					idInvitacion = invitacion.getString("id");

					flag = true;
				}
			}
			assertTrue(flag);

			// acepto la invitacion
			Map<String, Object> sendAceptar = new HashMap<String, Object>();
			sendAceptar.put("idInv", idInvitacion);
			sendAceptar.put("opcion", true);
			controller.responderInvitacion(session, sendAceptar);

		} catch (JSONException e) {
			fail("Error al recibir invitaciones.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void TestRecibiryRechazarInvitacion() {
		// me logueo como pepe
		Usuario u = userdao.findById("pepe").get();
		session.setAttribute("user", u);
		String idInvitacion = "";

		// cojo mis invitaciones
		String invitaciones = controller.getInvitaciones(session);
		JSONObject jso = null;
		JSONObject reunion = null;
		try {
			jso = new JSONObject(invitaciones);
		} catch (JSONException e) {
			fail("Error en getInvitaciones.");
		}

		// busco la invitacion de Elisa a la nueva reunion
		try {
			JSONArray jsa = (JSONArray) jso.get("invitaciones");
			boolean flag = false;

			for (int i = 0; i < jsa.length() && !flag; i++) {
				JSONObject invitacion = (JSONObject) jsa.get(i);
				reunion = (JSONObject) invitacion.get("reunion");

				if (reunion.get("title").equals(nombreTest)) {
					idInvitacion = invitacion.getString("id");
					flag = true;
				}
			}

			assertTrue(flag);

			// rechazo la invitacion
			Map<String, Object> send = new HashMap<String, Object>();
			send.put("idInv", idInvitacion);
			send.put("opcion", false);
			controller.responderInvitacion(session, send);

		} catch (JSONException e) {
			fail("Error al recibir invitaciones.");
		} catch (Exception e) {
			fail("Error al responder invitacion.");
		}
	}

}
