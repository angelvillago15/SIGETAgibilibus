package com.agibilibus.SIGET;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.ReunionDAO;
import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestEliminarReunionCalendario {
	private Controller controller = new Controller();

	@Autowired
	private UserDAO userdao;

	@Autowired
	private ReunionDAO reuniondao;

	MockHttpSession session = new MockHttpSession();
	Map<String, Object> reunion = new HashMap<String, Object>();

	@Test
	public void testOrganizador() {
		MockHttpSession session = new MockHttpSession();
		Usuario u = userdao.findById("Elisa").get();
		session.setAttribute("user", u);

		reunion.put("titulo", "EliminarReunion");
		reunion.put("fecha", "2020-10-01");
		reunion.put("horaInicio", "11:00:00");
		reunion.put("horaFin", "13:00:00");
		reunion.put("descripcion", "Hola");
		reunion.put("asistentes", "jaime@jaime, pepa@pepa.com");
		reunion.put("url", "https://www.google.com/");

		try {
			controller.guardarReunion(session, reunion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}

		boolean flag = false;
		List<Usuario> asistentes = new ArrayList();
		// Veo cual es el primer asistente que se tiene que convertir en organizador

		asistentes = reuniondao.findById("EliminarReunionPruebas").get().getAsistentes();
		Usuario primerAsistente = new Usuario();
		primerAsistente = asistentes.get(0);

		controller.eliminarReunionUsuario(session, reunion);

		if (reuniondao.findById("EliminarReunionPruebas").get().getOrganizador().equals(primerAsistente)) {
			flag = true;
		}

		assertTrue(flag);

	}
	/*
	 * @Test public void testAsistente() { //Asistente elimina reunión
	 * session.setAttribute("user", userdao.findById("Pepa"));
	 * reunion.put("correos", "pepa@pepa.com, elisa@elisa.com"); //aceptan
	 * invitacion controller.eliminarReunionUsuario(session, reunion);
	 * 
	 * }
	 * 
	 * @Test public void testUltimoOrganizador() { //Último organizador elimina
	 * reunión, la reunión se borra de la bbdd reunion.put("correos", "");
	 * controller.eliminarReunionUsuario(session, reunion);
	 * 
	 * }
	 */

}
