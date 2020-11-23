package com.agibilibus.siget;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.siget.controller.Controller;
import com.agibilibus.siget.dao.UserDAO;
import com.agibilibus.siget.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAdminEliminaUsuario {
	
	@Autowired
	private UserDAO usuariodao;
	
	private Controller controller = new Controller();
	
	@Test
	public void eliminaUsuario() {
		Map<String, Object> usuarioEliminado = new HashMap<String, Object>();
		MockHttpSession sesion = new MockHttpSession();
		
		sesion.setAttribute("user", usuariodao.findById("pepe").get());
		usuarioEliminado.put("id", "usuarioPruebaEliminar");
		controller.eliminarUsuario(sesion, usuarioEliminado);
		Optional<Usuario> optUser =  usuariodao.findById("usuarioPruebaEliminar");
		Assert.assertFalse(optUser.isPresent());
	}
	
}