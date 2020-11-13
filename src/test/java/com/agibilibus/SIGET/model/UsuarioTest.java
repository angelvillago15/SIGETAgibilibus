package com.agibilibus.SIGET.model;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.junit.Test;

import com.agibilibus.SIGET.dao.UserDAO;
import com.sun.el.parser.ParseException;

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
		usu.setNombre("pwd1");
		assertEquals("pwd1", usu.getNombre());
	}
	
	@Test
	public void testgetApellido() {
		inicio();
		usu.setApellidos("Fernandez");
		assertEquals("Fernandez", usu.getApellidos());
	}
	
	@Test
	public void testgetTelefono() {
		inicio();
		usu.setTelefono(92929);
		assertEquals(92929, usu.getTelefono());
	}
	
	@Test
	public void testgetEmail() {
		inicio();
		usu.setEmail("ala@uclm.es");
		assertEquals("ala@uclm.es", usu.getEmail());
	}
	
/*	@Test
	public void testgetDate() {
		inicio();
		//usu.setDate();
		assertEquals(, usu.getDate());
	}*/
	
	@Test
	public void testgetUser() {
		inicio();
		usu.setUser("Perico");
		assertEquals("Perico", usu.getUser());
	}
	
	@Test
	public void testgetDNI() {
		inicio();
		usu.setDNI("7878");
		assertEquals("7878", usu.getDNI());
	}
	
	@Test
	public void testgetPassword() {
		inicio();
		usu.setPassword("aaa22");
		assertEquals("aaa22", usu.getPassword());
	}
	
	@Test
	public void testgetRol() {
		inicio();
		usu.setRol("usuario");
		assertEquals("usuario", usu.getRol());
	}

	@Test
	public void testRegister() {
		assertEquals(true, usu1);
	
	}


	@Test
	public void testCrearUsuario() throws ParseException{
		inicio();
		usu.setNombre("Juan");
		usu.setApellidos("aaaa");
		usu.setTelefono(9825448);
		usu.setDNI("71486");
		usu.setEmail("aa@oaskao.com");
		usu.setDate(null);
		usu.setUser("pwd1");
		usu.setPassword("pwf44");
		usu.setRol("usuario");
		
		try {
			usu.crearUsuario("pwd1", "nombreCompleto", "nombre", "apellidos", null, "userDni", 9855000, "email@email.com");
			fail("Excepcion");
		}catch(Exception e){
			System.out.println("Crear Usuario:" + usu.getNombre());
		}
		//assertEquals(false, usu.crearUsuario("pwd1", "nombreCompleto", "nombre", "apellidos", null, "userDni", 9855000, "email@email.com"));
	}

	@Test
	public void testModificarUsuario() {
		inicio();
		assertEquals(usu1, usu.modificarUsuario(usu1));
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
