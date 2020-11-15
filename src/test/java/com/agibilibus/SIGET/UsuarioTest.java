package com.agibilibus.SIGET;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.agibilibus.SIGET.model.Usuario;
import com.sun.el.parser.ParseException;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {
	static Usuario usu;
	static Usuario usu1;
	static Usuario usu2;
	
	public void inicio() {
		usu = new Usuario("Alfonso", "oaijsdoiajs", "Alfon", "megia", 66846864, "alf@gmail.com", "1648498a",
				DateTime.parse("2019-01-02"), "usuario");
		usu1 = new Usuario();
		usu2 = new Usuario();
	}

	@Test
	public void testRegister() {

	}

	@Test
	public void testCrearUsuarioTrue() throws ParseException {
		inicio();

		try {
			usu1.get().crearUsuario("Al442ss", "Alberto ", "Alber", "Fernandez", DateTime.parse("2019-01-02"),
					"7022548R", 9855000, "email@email.com");

		} catch (Exception e) {
			System.out.println("Crear Usuario:" + usu1.getNombre());
		}

	}

	@Test
	public void testCrearUsuarioFalse() throws ParseException {
		inicio();

		try {
			usu2.crearUsuario(null, null, "nombre", "apellidos", DateTime.parse("2019-01-02"), "userDni", 9855000,
					"email@email.com");
		} catch (Exception e) {
			System.out.println("Error al crear el usuario: " + usu2.getNombre());
		}

	}

	@Test
	public void testModificarUsuario() {
		inicio();
		usu.get().setApellidos("Palencia");
		usu.get().setDNI("78484984");
		usu.get().setDate(DateTime.parse("2015-01-02"));
		usu.get().setEmail("kaoskopa@gmail.com");
		usu.get().setNombre("Fernanda");
		usu.get().setPassword("asdsad33");
		usu.get().setTelefono(48948984);
		usu.get().setRol("Administrador");
		usu.get().setUser("Fler");

		assertEquals("Palencia", usu.get().getApellidos());
		assertEquals("78484984", usu.get().getDNI());
		assertEquals(DateTime.parse("2015-01-02"), usu.get().getDate());
		assertEquals("kaoskopa@gmail.com", usu.get().getEmail());
		assertEquals("Fernanda", usu.get().getNombre());
		assertEquals("asdsad33", usu.get().getPassword());
		assertEquals(48948984, usu.get().getTelefono());
		assertEquals("Administrador", usu.get().getRol());
		assertEquals("Fler", usu.get().getUser());

	}
	
	@Test
	public void testJSONObject() {
		inicio();
		try {
			usu.get().toJSON();
		} catch (Exception e) {
			System.out.println("Error en toJSON "+ e);
		}
		
	}
	
	@Test
	public void testEquals_1() {
		inicio();
		try {
			Object obj = null;
			usu.get().equals(obj);
		} catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		
	}
	
	@Test
	public void testEquals_2() {
		inicio();
		try {
			Object obj = usu.get();
			usu.get().equals(obj);
		} catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		
	}

	@Test
	public void testhHashCode() {
		inicio();
		try {
			usu.get().hashCode();
		} catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		
	}

}
