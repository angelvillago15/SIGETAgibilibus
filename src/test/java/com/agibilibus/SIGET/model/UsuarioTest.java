package com.agibilibus.SIGET.model;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.junit.Test;

import com.agibilibus.SIGET.dao.UserDAO;

import junit.framework.Assert;

public class UsuarioTest {
	static Usuario usu;
	static Usuario usu1;
	
	static UserDAO userdao;
	
	public void inicio() {
		usu = new Usuario();
		usu1= new Usuario();
	}
	
	
	@Test
	public void testgetNombre() {
		inicio();
		assertEquals(true, usu.getNombre());
	}
	
	@Test
	public void testgetApellido() {
		inicio();
		assertEquals(true, usu.getApellidos());
	}
	
	@Test
	public void testgetTelefono() {
		inicio();
		assertEquals(true, usu.getTelefono());
	}
	
	@Test
	public void testgetEmail() {
		inicio();
		assertEquals(true, usu.getEmail());
	}
	
	@Test
	public void testgetDate() {
		inicio();
		assertEquals(true, usu.getDate());
	}
	
	@Test
	public void testgetUser() {
		inicio();
		assertEquals(true, usu.getUser());
	}
	
	@Test
	public void testgetDNI() {
		inicio();
		assertEquals(true, usu.getDNI());
	}
	
	@Test
	public void testgetPassword() {
		inicio();
		assertEquals(true, usu.getPassword());
	}
	
	@Test
	public void testgetRol() {
		inicio();
		assertEquals(true, usu.getRol());
	}

	@Test
	public void testRegister() {
		usu1 =usu.register();
		assertEquals(true, usu1);
	
	}


	@Test
	public void testCrearUsuario() {
		inicio();
		assertEquals(false, usu.crearUsuario("pwd1", "nombreCompleto", "nombre", "apellidos", null, "userDni", 9855000, "email@email.com"));
	}

	@Test
	public void testModificarUsuario() {
		
		assertEquals(false, usu.modificarUsuario(usu1));
	}
	
	/*

	@Test
	public void testEliminarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}
*/
}
