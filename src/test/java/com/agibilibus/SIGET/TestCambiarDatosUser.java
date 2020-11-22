package com.agibilibus.SIGET;

import static org.junit.Assert.assertNotEquals;
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
	
	@Test
	void testCambiarDatosUser() {
		try {
			Map<String, Object> credenciales = new HashMap<String, Object>();
			credenciales.put("userCompletName", "Prueba");
			credenciales.put("userName", "Prueba");
			credenciales.put("userApellidos", "Prueba");
			credenciales.put("userDate", "1999-11-10");
			credenciales.put("userDni", "Prueba");
			credenciales.put("userTelf", 666);
			credenciales.put("userMail", "Prueba");
			credenciales.put("pwd1", "contraseña");
			credenciales.put("rol", "usuario");
			controller.modificar(sesion, credenciales);
		}catch (Exception e) {
			fail("Se ha lanzado una excepcion inesperada: " + e);
		}
	}

}
