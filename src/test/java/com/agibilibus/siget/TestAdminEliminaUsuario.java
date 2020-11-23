package com.agibilibus.SIGET;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
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
import com.agibilibus.SIGET.dao.InvitacionDAO;
import com.agibilibus.SIGET.dao.ReunionDAO;
import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Invitacion;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAdminEliminaUsuario {
	
	@Autowired
	private UserDAO usuariodao;
	
	@Autowired
	private InvitacionDAO invitaciondao;
	
	@Autowired
	private ReunionDAO reuniondao;
	
	private Controller controller = new Controller();
	private Map<String, Object> usuarioEliminado = new HashMap<String, Object>();
	private MockHttpSession sesion = new MockHttpSession();
	private Reunion r1;
	private Reunion r2;
	
	
	@Before
	public void init() throws NoSuchAlgorithmException, JSONException {
		//Crea usuario que va a eliminar
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
		
		//Crea dos reuniones
		String [] asistentesR1 = new String[1];
		String [] asistentesR2 = new String[3];
		asistentesR2[0] = "para@eliminar";
		asistentesR2[1] = "Prueba";
		asistentesR2[2] = "elisa@elisa.com";
		r1 = Reunion.get().guardarReunion("reunion organizador usuario para eliminar", "", DateTime.parse("2020-11-01T12:00:00.000"), DateTime.parse("2020-11-01T14:00:00.000"),usuariodao.findById("userparaborrar").get() , asistentesR1, "www.reunion.com");
		r2 = Reunion.get().guardarReunion("reunion asistente usuario para eliminar", "", DateTime.parse("2020-11-02T12:00:00.000"), DateTime.parse("2020-11-02T14:00:00.000"),(Usuario) sesion.getAttribute("user"), asistentesR2, "www.reunion.com");
	}
	
	@Test
	public void eliminaUsuario() {
		controller.eliminarUsuario(sesion, usuarioEliminado);
		Optional<Usuario> optUser =  usuariodao.findById("userparaborrar");
		Assert.assertFalse(optUser.isPresent());
		Reunion.get().eliminarReunion(r1);
		Reunion.get().eliminarReunion(r2);
	}
	
	@Test
	public void eliminaInvitaciones() {
		List<Invitacion> listaInvitaciones = invitaciondao.findAll();
		String idInvitacion = "";
		Optional<Invitacion> optI = null;
		for (Invitacion i : listaInvitaciones)
			if(i.getUsuario().getUser().equals(usuariodao.findById("userparaborrar").get().getUser())) {
				idInvitacion = i.getIdInvitacion();
				optI = invitaciondao.findById(idInvitacion);
			}
		Assert.assertTrue(optI.isPresent());
		controller.eliminarUsuario(sesion, usuarioEliminado);
		optI = invitaciondao.findById(idInvitacion);
		Assert.assertFalse(optI.isPresent());
		Reunion.get().eliminarReunion(r1);
		Reunion.get().eliminarReunion(r2);
	}
	
	@Test 
	public void eliminaUsuarioComoAsistente() {
		Usuario userEliminar = usuariodao.findById("userparaborrar").get();
		Assert.assertTrue(r2.getAsistentes().contains(userEliminar));
		controller.eliminarUsuario(sesion, usuarioEliminado);
		Assert.assertFalse(reuniondao.findById(r2.getIdReunion()).get().getAsistentes().contains(userEliminar));
		Reunion.get().eliminarReunion(r1);
		Reunion.get().eliminarReunion(r2);
	}
	
	
	
}