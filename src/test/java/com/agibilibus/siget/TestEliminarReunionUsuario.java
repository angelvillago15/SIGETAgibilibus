package com.agibilibus.siget;


import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.siget.controller.Controller;
import com.agibilibus.siget.dao.ReunionDAO;
import com.agibilibus.siget.dao.UserDAO;
import com.agibilibus.siget.model.Reunion;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestEliminarReunionUsuario {
	@Autowired
	private UserDAO usuariodao;
	@Autowired
	private ReunionDAO reuniondao;

	private Controller controller = new Controller();
	private static Map<String, Object> usuarioEliminaReunion = new HashMap<String, Object>();
	private static MockHttpSession session = new MockHttpSession();
	private Map<String, Object> reunion = new HashMap<String, Object>();
	private Map<String, Object> reunion1 = new HashMap<String, Object>();
	private Reunion r;
	private Reunion r1;
	
	@Before
	public void init() throws Exception {
		//Usuario
		usuarioEliminaReunion.put("userCompletName", "usuario");
		usuarioEliminaReunion.put("userName", "usuarioEliminaReunion");
		usuarioEliminaReunion.put("userApellidos", "eliminaReunion");
		usuarioEliminaReunion.put("userDate", "2020-11-30");
		usuarioEliminaReunion.put("userDni", "0000001");
		usuarioEliminaReunion.put("userTelf", "666666666");
		usuarioEliminaReunion.put("userMail", "user@eliminareunion");
		usuarioEliminaReunion.put("pwd1", "Hola1234");
		usuarioEliminaReunion.put("id", "usuarioEliminaReunion");
		controller.register(session, usuarioEliminaReunion);
		
		//Reunion organizador
		session.setAttribute("user", usuariodao.findById("usuarioEliminaReunion").get());
		reunion.put("nombre", "Reunion usuario elimina reunion");
		reunion.put("fecha", "2020-10-01");
		reunion.put("horaInicio", "11:00:00");
		reunion.put("horaFin", "13:00:00");
		reunion.put("descripcion", "Organizador");
		reunion.put("url", "https://www.google.com/");
		reunion.put("correos", "jaime@jaime.com");
		r = controller.guardarReunion(session, reunion);		
		
		//Reunion asistente
		session.setAttribute("user", usuariodao.findById("usuarioEliminaReunion").get());
		reunion1.put("nombre", "Reunion usuario elimina reunion");
		reunion1.put("fecha", "2020-10-01");
		reunion1.put("horaInicio", "11:00:00");
		reunion1.put("horaFin", "13:00:00");
		reunion1.put("descripcion", "Asistente");
		reunion1.put("url", "https://www.google.com/");
		reunion1.put("correos", "user@eliminareunion");
		controller.guardarReunion(session, reunion1);	
		
	}
	
	@After
	public void liberarRecursos() {
		reuniondao.deleteById(r.getIdReunion());
		reuniondao.deleteById(r1.getIdReunion());
		usuariodao.deleteById("usuarioEliminaReunion");
		
		
	}
	@Test
	public void testEliminarReunionValida() {
		session.setAttribute("user", usuariodao.findById("usuarioEliminaReunion").get());
		controller.eliminarReunionUsuario(session, reunion);
	}
	
	
	
	
}
