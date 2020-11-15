package com.agibilibus.SIGET;

import static org.junit.Assert.fail;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.agibilibus.SIGET.model.Sesion;
import com.agibilibus.SIGET.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestLogin {
	
	@Autowired
	HttpSession sesion;
	
	@Test
	void test() {
		try {
			Usuario.get().crearUsuario("99999999A", "Cristina", "cris", "pruebas", DateTime.parse("2020-11-30"), "99999999A", 666666666, "cristina@gmail.com");
			Sesion.get().login(sesion, "cris", "99999999A");
		}catch (Exception e) {
			fail("Se ha lanzado una excepcion inesperada: " + e);
		}
	}

}
