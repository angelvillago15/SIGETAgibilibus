package com.agibilibus.siget;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.siget.controller.Controller;
import com.agibilibus.siget.dao.InvitacionDAO;
import com.agibilibus.siget.dao.UserDAO;
import com.agibilibus.siget.model.Invitacion;
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
	private InvitacionDAO invitaciondao;

	private Controller controller = new Controller();
	private String nombreTest = "TestInvitaciones2";
	private static Reunion reunion;
	private static Invitacion invitacionJaime;
	private static Invitacion invitacionPepe;
	
	@AfterClass
	public static void liberaRecursos() {
		Reunion.get().eliminarReunion(reunion);
		Invitacion.get().eliminarInvitacion(invitacionJaime);
		Invitacion.get().eliminarInvitacion(invitacionPepe);
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
			fail(""+e);
		}
	}

	@Test
	public void TestRecibiryAceptarInvitacion() {
		// me logueo como jaime
		Usuario u = userdao.findById("jaime").get();
		session.setAttribute("user", u);

		// cojo mis invitaciones
		
		List<Invitacion> listaInvitaciones = invitaciondao.findAll();
		boolean flag = false;
		for (Invitacion i : listaInvitaciones) {
			if (i.getUsuario().getUser().equals("jaime")) {	
				invitacionJaime = i;
				
				flag = true;
			}
		}
		assertTrue(flag);
		
		// acepto la invitacion
		Map<String, Object> sendAceptar = new HashMap<String, Object>();
		sendAceptar.put("idInv", invitacionJaime.getIdInvitacion());
		sendAceptar.put("opcion", true);
		try {
			controller.responderInvitacion(session, sendAceptar);
		} catch (Exception e) {
			fail("Error al responder la invitacion"+e);
		}
	}

	@Test
	public void TestRecibiryRechazarInvitacion() {
		// me logueo como pepe
		Usuario u = userdao.findById("pepe").get();
		session.setAttribute("user", u);
		// cojo mis invitaciones
		List<Invitacion> listaInvitaciones = invitaciondao.findAll();
		boolean flag = false;
		for (Invitacion i : listaInvitaciones) {
			if (i.getUsuario().getUser().equals("pepe")) {	
				invitacionPepe = i;
				flag = true;
			}
		}
		assertTrue(flag);
		// rechazo la invitacion
		Map<String, Object> send = new HashMap<String, Object>();
		send.put("idInv", invitacionPepe.getIdInvitacion());
		send.put("opcion", false);
		try {
			controller.responderInvitacion(session, send);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
