package com.agibilibus.SIGET;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.ReunionDAO;
import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

import java.util.HashMap;
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
	
	private Reunion r;

	MockHttpSession session = new MockHttpSession();
	Map<String, Object> reunion = new HashMap<String, Object>();

	@Before
	public void init() throws Exception {
		MockHttpSession session = new MockHttpSession();
		Usuario u = userdao.findById("carlos").get();
		session.setAttribute("user", u);
		reunion.put("nombre", "EliminarReunion");
		reunion.put("fecha", "2020-10-01");
		reunion.put("horaInicio", "11:00:00");
		reunion.put("horaFin", "13:00:00");
		reunion.put("descripcion", "Hola");
		reunion.put("url", "https://www.google.com/");
		
		
	}

	@Test
	public void testOrganizador() throws Exception {
		reunion.put("correos", "pepa@pepa.com");
		System.out.println(reunion);
		controller.guardarReunion(session, reunion);
		JSONObject jso = new JSONObject(controller.getReuniones(session));
		System.out.println(jso.get("id"));
		//aceptan invitacion
		//controller.eliminarReunionUsuario(session, reunion);
		
		
	}

	/*@Test
	public void testAsistente() {
		//Asistente elimina reunión
		session.setAttribute("user", userdao.findById("Pepa"));
		reunion.put("correos", "pepa@pepa.com, elisa@elisa.com");
		//aceptan invitacion
		controller.eliminarReunionUsuario(session, reunion);

	}

	@Test
	public void testUltimoOrganizador() {
		//Último organizador elimina reunión, la reunión se borra de la bbdd
		reunion.put("correos", "");
		controller.eliminarReunionUsuario(session, reunion);

	}*/

}
