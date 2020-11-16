/*package com.agibilibus.SIGET;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestCambiarDatosUser {
	
	@Autowired
	private HttpSession sesion;
	
	private Controller controller = new Controller();
	private Map<String, Object> credenciales = new HashMap<String, Object>();
	
	@Test
	void testCambiarDatosUser() {
		try {
			Usuario u = new Usuario("cris", "99999999A", "Cristina", "pruebas", 666666666, "cristina@gmail.com","99999999A", DateTime.parse("2020-11-30"), "usuario");
			u.crearUsuario("99999999A", "Cristina", "cris", "pruebas", DateTime.parse("2020-11-30"), "99999999A", 666666666, "cristina@gmail.com");
			controller.modificar(sesion, u, credenciales);
		}catch (Exception e) {
			fail("Se ha lanzado una excepcion inesperada: " + e);
		}
	}

}*/
