package com.agibilibus.SIGET;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.ReunionDAO;
import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestEliminarReunionCalendario {
	private Controller controller = new Controller();

	@Autowired
	private UserDAO userdao;

	@Autowired
	private ReunionDAO reuniondao;

	MockHttpSession session = new MockHttpSession();

	@Before
	public void iniciar() {
		
		//me logueo como Elisa
		session = new MockHttpSession();
		Usuario u = userdao.findById("Elisa").get();
		session.setAttribute("user", u);
		
		//creo una reunion
		Map<String, Object> reunion = new HashMap<String, Object>();
		reunion.put("nombre", "EliminarReunion");
		reunion.put("descripcion", "Hola");
		reunion.put("fecha", "2020-10-01");
		reunion.put("horaInicio", "11:00:00");
		reunion.put("horaFin", "13:00:00");
		reunion.put("url", "https://www.google.com/");
		reunion.put("correos", "jaime@jaime.com, pepa@pepa.com");

		try {
			controller.guardarReunion(session, reunion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}

	}

	@Test
	public void testOrganizador() {
		
		Map<String, Object> sendReunion = new HashMap<String, Object>();
		sendReunion.put("idReunion","Elisa#EliminarReunion#2020-10-01T11:00:00.000+02:00#2020-10-01T13:00:00.000+02:00#jaime#Pepa");
		
		//cojo los asistentes
		List<Usuario> asistentes = reuniondao.findById("Elisa#EliminarReunion#2020-10-01T11:00:00.000+02:00#2020-10-01T13:00:00.000+02:00#jaime#Pepa").get().getAsistentes();
		Usuario jaime = asistentes.get(0);
		Usuario pepa = asistentes.get(1);


		//estoy logueada como Elisa y cambio el organizador por jaime
		controller.eliminarReunionUsuario(session, sendReunion);
		Reunion reunion = reuniondao.findById("Elisa#EliminarReunion#2020-10-01T11:00:00.000+02:00#2020-10-01T13:00:00.000+02:00#jaime#Pepa").get();
		assertEquals((reunion.getOrganizador()), jaime);

		//me logueo como jaime cambio el organizador por pepa
		session.setAttribute("user", jaime);
		controller.eliminarReunionUsuario(session, sendReunion);
		reunion = reuniondao.findById("Elisa#EliminarReunion#2020-10-01T11:00:00.000+02:00#2020-10-01T13:00:00.000+02:00#jaime#Pepa").get();
		assertEquals((reunion.getOrganizador()), pepa);

		// me logueo como pepa y elimino la reunion
		session.setAttribute("user", pepa);
		controller.eliminarReunionUsuario(session, sendReunion);
		assertFalse(reuniondao.findById("Elisa#EliminarReunion#2020-10-01T11:00:00.000+02:00#2020-10-01T13:00:00.000+02:00#jaime#Pepa").isPresent());

	}

}
