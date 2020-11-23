package com.agibilibus.siget;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.siget.controller.Controller;
import com.agibilibus.siget.dao.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCrearReunion {

	private Controller controller = new Controller();

	@Autowired
	private UserDAO userdao;

	@Test
	public void testCrearReunion() {

		Map<String, Object> reunion = new HashMap<String, Object>();
		MockHttpSession session = new MockHttpSession();

		session.setAttribute("user", userdao.findById("carlos").get());
		reunion.put("nombre", "Mañanera");
		reunion.put("fecha", "2020-10-01");
		reunion.put("horaInicio", "11:00:00");
		reunion.put("horaFin", "13:00:00");
		reunion.put("descripcion", "Fallos");
		reunion.put("url", "https://www.google.com/");
		reunion.put("correos", "a@gmail.com");

		try {
			controller.guardarReunion(session, reunion);
		} catch (Exception e) {
			fail("Error creando reunion: " + e);

		}
	}

}
