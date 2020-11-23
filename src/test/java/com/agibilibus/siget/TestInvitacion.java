package com.agibilibus.siget;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.siget.controller.Controller;
import com.agibilibus.siget.dao.InvitacionDAO;
import com.agibilibus.siget.dao.ReunionDAO;
import com.agibilibus.siget.dao.UserDAO;
import com.agibilibus.siget.model.Reunion;
import com.agibilibus.siget.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestInvitacion {

	@Autowired
	private MockHttpSession session;
	@Autowired
	private UserDAO userdao;
	@Autowired
	private ReunionDAO reuniondao;
	@Autowired
	private InvitacionDAO invitaciondao;

	private Controller controller = new Controller();
	private String nombreTest = "TestInvitaciones2";
	private Reunion reunion;
	private String idInvitacionJaime = "";
	private String idInvitacionPepe = "";
	
	
	@Before
	public void init() {
		
		
	}
	@After
	public void end() {
		reuniondao.deleteById(this.reunion.getIdReunion());
		invitaciondao.deleteById(idInvitacionJaime);
		invitaciondao.deleteById(idInvitacionPepe);
		
	}
	

	@Test
	public void TestCrearYEnviarInvitacion() {
		// me logueo como Elisa
		session = new MockHttpSession();
		Usuario u = userdao.findById("Elisa").get();
		session.setAttribute("user", u);

		// creo una reunion
		Map<String, Object> datosReunion = new HashMap<String, Object>();
		datosReunion.put("nombre", nombreTest);
		datosReunion.put("descripcion", "Hola");
		datosReunion.put("fecha", "2020-10-01");
		datosReunion.put("horaInicio", "11:00:00");
		datosReunion.put("horaFin", "13:00:00");
		datosReunion.put("url", "https://www.google.com/");
		datosReunion.put("correos", "jaime@jaime.com, pepe");
		try {
			
			reunion = controller.guardarReunion(session, datosReunion);
			
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void TestRecibiryAceptarInvitacion() {
		// me logueo como jaime
		Usuario u = userdao.findById("jaime").get();
		session.setAttribute("user", u);
		

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
				JSONObject usuario = (JSONObject) invitacion.get("usuario");

				if (usuario.get("user").equals(u)) {
					idInvitacionJaime = invitacion.getString("id");

					flag = true;
				}
			}
			assertTrue(flag);

			// acepto la invitacion
			Map<String, Object> sendAceptar = new HashMap<String, Object>();
			sendAceptar.put("idInv", idInvitacionJaime);
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
					idInvitacionPepe = invitacion.getString("id");
					flag = true;
				}
			}

			assertTrue(flag);

			// rechazo la invitacion
			Map<String, Object> send = new HashMap<String, Object>();
			send.put("idInv", idInvitacionPepe);
			send.put("opcion", false);
			controller.responderInvitacion(session, send);

		} catch (JSONException e) {
			fail("Error al recibir invitaciones.");
		} catch (Exception e) {
			fail("Error al responder invitacion.");
		}
	}

}
