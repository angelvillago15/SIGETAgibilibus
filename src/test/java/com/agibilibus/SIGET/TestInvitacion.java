package com.agibilibus.SIGET;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.InvitacionDAO;
import com.agibilibus.SIGET.model.EstadoInvitacion;
import com.agibilibus.SIGET.model.Invitacion;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Sesion;
import com.agibilibus.SIGET.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest

class InvitacionTest {

	@Autowired
	private HttpSession sesion;
	@Autowired
	private InvitacionDAO invitaciondao;

	private Reunion r = new Reunion();
	private Invitacion inv = new Invitacion();

	@Test
	void TestCrearInvitacion() {
		Controller controller = new Controller();
		Map<String, Object> credenciales = new HashMap<>();
		JSONObject jso = new JSONObject();
		
		jso.put(user, );
		controller.login(sesion, (Map<String, Object>) jso);


		
		Usuario organizador = (Usuario) sesion.getAttribute("user");
		r.guardarReunion("Graduacion", "Graduacion","10:00:00","12:00:00", organizador, ["jaime@jaime.com"], "http://www.chuidiang.org/java/herramientas/test-automaticos/ejemplo-junit.php");
		assertTrue(invitaciondao.exists(r.getIdReunion()+u.getUser()), true);
		
	}

	@Test
	void TestEnviarInvitacion() {
		try {
			Sesion.get().login(sesion, "Elisa", "Seguridad2020");
		}catch(Exception e) {
			fail();
		}

		Usuario organizador = (Usuario) sesion.getAttribute("user");
		Controller controller = new Controller();
		controller.
		Invitacion inv = new Invitacion ("Prueba junit","Jaime", "Graduacion", EstadoInvitacion.pendiente);
		invitaciondao.save(inv);
		inv.enviarInivitacion("Prueba junit", ["jaime@jaime.com"]);
		assertTrue(inv.getReunion().getAsistentes().contains("Jaime"), true);
		
	}

	@Test
	void TestRecibirInvitacion() {
		Sesion.get().login(sesion, "Jaime", "Seguridad2020");
		
		Reunion r = new Reunion();		r.guardarReunion("Graduacion", "Graduacion","10:00:00","12:00:00", organizador, ["jaime@jaime.com"], "http://www.chuidiang.org/java/herramientas/test-automaticos/ejemplo-junit.php");

	}

}
