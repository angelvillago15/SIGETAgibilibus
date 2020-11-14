package com.agibilibus.SIGET.model;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;

import com.agibilibus.SIGET.dao.UserDAO;
import com.sun.el.parser.ParseException;

import junit.framework.Assert;

public class UsuarioTest {
	static Usuario usu;
	static Usuario usu1;
	static Usuario usu2;
	static UserDAO dao;
	
	public void inicio() {
		usu = new Usuario("Alfonso", "oaijsdoiajs", "Alfon", "megia", 66846864, "alf@gmail.com", "1648498a", DateTime.parse("2019-01-02"), "usuario");
		usu1= new Usuario();
		usu2= new Usuario();
	}
	

	@Test
	public void testRegister() {
		
	}


	@Test
	public void testCrearUsuarioTrue() throws ParseException{
		inicio();
		
		try {
			usu1.crearUsuario("Al442ss", "Alberto ", "Alber", "Fernandez",DateTime.parse("2019-01-02") , "7022548R", 9855000, "email@email.com");
			fail("Excepcion");
		}catch(Exception e){
			System.out.println("Crear Usuario:" + usu1.getDNI());
		}
		
	}
	
	@Test
	public void testCrearUsuarioFalse() throws ParseException{
		inicio();
		
		try {
			usu2.crearUsuario("Juan", null, "nombre", "apellidos",DateTime.parse("2019-01-02") , "userDni", 9855000, "email@email.com");
			fail("Excepcion");
		}catch(Exception e){
			System.out.println("Error al crear el usuario: " + usu2.getNombre());
		}
		
	}

	@Test
	public void testModificarUsuario() {
		inicio();
		usu.setApellidos("Palencia");
		usu.setDNI("78484984");
		usu.setDate(DateTime.parse("2015-01-02"));
		usu.setEmail("kaoskopa@gmail.com");
		usu.setNombre("Fernanda");
		usu.setPassword("asdsad33");
		usu.setTelefono(48948984);
		usu.setRol("Administrador");
		usu.setUser("Fler");
		
		assertEquals("Palencia", usu.getApellidos());
		assertEquals("78484984", usu.getDNI());
		assertEquals(DateTime.parse("2015-01-02"), usu.getDate());
		assertEquals("kaoskopa@gmail.com", usu.getEmail());
		assertEquals("Fernanda", usu.getNombre());
		assertEquals("asdsad33", usu.getPassword());
		assertEquals(48948984, usu.getTelefono());
		assertEquals("Administrador", usu.getRol());
		assertEquals("Fler", usu.getUser());
		
	}
	
	
}
