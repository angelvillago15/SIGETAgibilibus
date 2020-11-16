package com.agibilibus.SIGET;

import static org.junit.jupiter.api.Assertions.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestCrearReunion {
	
	@Autowired
	private HttpSession sesion;

	private Controller controller = new Controller();
	private Map<String, Object> reunion = new HashMap<String, Object>();
	private String nombreTest = "test";


	@Test
	void testCrearReunion()  {
		Map<String, Object> credenciales = new HashMap<String, Object>();
		credenciales.put("userName", "Alberto ");
		credenciales.put("pwd", "Al442ss");

		try {
			controller.login(sesion, credenciales);
		} catch (Exception e1) {
			fail("Error creando reunion: "+ e1);

		}
		reunion.put("nombre", "Mañanera");
		reunion.put("fecha", "2020-15-01");
		reunion.put("horaInicio", "11:00:00");
		reunion.put("horaFin", "13:00:00");
		reunion.put("descripcion", "Fallos");
		reunion.put("url", "https://www.google.com/");
		reunion.put("correos", "a@gmail.com");
		
		try {
			controller.guardarReunion(sesion, reunion);
		}catch(Exception e) {
			fail("Error creando reunion: "+ e);
			
		}
	}
	



}
