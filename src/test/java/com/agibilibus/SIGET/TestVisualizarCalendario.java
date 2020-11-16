package com.agibilibus.SIGET;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.model.ERol;
import com.agibilibus.SIGET.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestVisualizarCalendario {
	
	@Test
	public void testGetReuniones() {
		
		try {
		Usuario.get().crearUsuario("99999999A", "Cristina", "cris", "pruebas", DateTime.parse("2020-11-30"), "99999999A", 666666666, "cristina@gmail.com");
		} catch (Exception e) {
			fail("Se ha lanzado una excepcion inesperada: " + e);
		}
		
	}
	
	@Test
	public void testUsuarioSinReuniones() {
	
		try {
			Usuario cristina = new Usuario("Cristina", "99999999A", "Cristina", "Marugan", 666666666, "cristina@gmail.com", "00000000X", DateTime.parse("2020-11-30"), "usuario");
			
			//fail("Esperaba NoHayReunionesException");
		} /*catch(NoHayReunionesException e) {
			
		} */catch (Exception e) {
			fail("Se ha lanzado una excepcion inesperada: " + e);
		}
	}
	
}
	

	