package com.agibilibus.SIGET;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.ReunionDAO;
import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Reunion;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEliminarReunionCalendario {

	private Controller controller = new Controller();

	@Autowired
	private UserDAO userdao;
	@Autowired
	private ReunionDAO reuniondao;

	@Test
	public void testEliminarReunion() {

		Map<String, Object> reunion = new HashMap<String, Object>();
		MockHttpSession session = new MockHttpSession();

		session.setAttribute("user", userdao.findById("carlos").get());
		reunion.put("id", "prueba");
		reunion.put("nombre", "Mañanera");
		reunion.put("fecha", "2020-10-01");
		reunion.put("horaInicio", "11:00:00");
		reunion.put("horaFin", "13:00:00");
		reunion.put("descripcion", "Fallos");
		reunion.put("url", "https://www.google.com/");
		reunion.put("correos", "a@gmail.com");

		try {
			controller.guardarReunion(session, reunion);
			reuniondao.deleteById(((Reunion) reunion).getIdReunion());
		} catch (Exception e) {
			fail("Error creando reunion: " + e);

		}
	}

}