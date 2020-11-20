package com.agibilibus.SIGET;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.joda.time.DateTime;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAdminEliminaUsuario {
	
	@Autowired
	private UserDAO usuariodao;
	
	private Controller controller = new Controller();
	Map<String, Object> usuarioEliminado = new HashMap<String, Object>();
	private MockHttpSession sesion = new MockHttpSession();
	Map<String, Object> reunionOrganizadorUsuarioEliminado = new HashMap<String, Object>();

	Map<String, Object> reunionAsistenteUsuarioEliminado = new HashMap<String, Object>();
	
	@Before
	public void init() throws NoSuchAlgorithmException, JSONException {
		sesion.setAttribute("user", usuariodao.findById("pepe").get());
		usuarioEliminado.put("userCompletName", "usuario");
		usuarioEliminado.put("userName", "userparaborrar");
		usuarioEliminado.put("userApellidos", "paraborrar");
		usuarioEliminado.put("userDate", "2020-11-30");
		usuarioEliminado.put("userDni", "0000001");
		usuarioEliminado.put("userTelf", "666666666");
		usuarioEliminado.put("userMail", "para@eliminar");
		usuarioEliminado.put("pwd1", "Hola1234");
		usuarioEliminado.put("id", "userparaborrar");
		controller.register(sesion, usuarioEliminado);
		
		String [] asistentes = new String[1];
		Reunion.get().guardarReunion("reunion organizador usuario para eliminar", "", DateTime.parse("2020-11-01T12:00:00.000"),  DateTime.parse("2020-11-01T14:00:00.000"), (Usuario) sesion.getAttribute("user"), asistentes, "www.reunion.com");
		
	}
	
	@Test
	public void eliminaUsuario() {
		controller.eliminarUsuario(sesion, usuarioEliminado);
		Optional<Usuario> optUser =  usuariodao.findById("userparaborrar");
		Assert.assertFalse(optUser.isPresent());
	}
	
	@Test
	public void eliminaInvitaciones() {
		
	}
	
	@Test 
	public void eliminaUsuarioComoAsistente() {
		
	}
	
}