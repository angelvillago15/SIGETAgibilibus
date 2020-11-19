package com.agibilibus.SIGET;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAdminEliminaUsuario {
	
	@Autowired
	private UserDAO usuariodao;
	
	private Controller controller = new Controller();
	
	@Test
	public void eliminaUsuarioNoExiste() {
		Map<String, Object> usuarioEliminado = new HashMap<String, Object>();
		MockHttpSession sesion = new MockHttpSession();
		Optional <Usuario> optUsuarioAdmin = usuariodao.findById("pepe");
		Optional <Usuario> optUsuarioEliminar = usuariodao.findById("eliminaUsuarioNoExiste");
		if (optUsuarioAdmin.isPresent()) { 
			sesion.setAttribute("user", optUsuarioAdmin.get());
			if (optUsuarioEliminar.isPresent()) {
				usuarioEliminado.put("id", "eliminaUsuarioNoExiste");
				controller.eliminarUsuario(sesion, usuarioEliminado);
				Optional<Usuario> optUser =  usuariodao.findById("eliminaUsuarioNoExiste");
				Assert.assertFalse(optUser.isPresent());
			}
		}
	}
	
	@Test 
	public void eliminarUsuario() {
		Usuario.get().crearUsuario("eliminarUsuario", "eliminarUsuario", "eliminar", "usuario", DateTime.parse("2020-11-30"), "00000000V", 666666666, "eliminar@gmail.com");
		Map<String, Object> usuarioEliminado = new HashMap<String, Object>();
		MockHttpSession sesion = new MockHttpSession();
		Optional <Usuario> optUsuarioAdmin = usuariodao.findById("pepe");
		Optional <Usuario> optUsuarioEliminar = usuariodao.findById("eliminarUsuario");
		if (optUsuarioAdmin.isPresent()) { 
			sesion.setAttribute("user", optUsuarioAdmin.get());
			if (optUsuarioEliminar.isPresent()) {
				usuarioEliminado.put("id", "eliminarUsuario");
				controller.eliminarUsuario(sesion, usuarioEliminado);
				Optional<Usuario> optUser =  usuariodao.findById("eliminarUsuario");
				Assert.assertFalse(optUser.isPresent());
			}
		}
	}
}