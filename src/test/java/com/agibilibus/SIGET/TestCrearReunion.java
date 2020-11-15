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

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestCrearReunion {
	Controller controller = new Controller();
	@Autowired
	UserDAO userdao;

	@Test
	void testCrearReunion()  throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
    IllegalBlockSizeException, BadPaddingException, JSONException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("titulo", "Mi reunion");
		map.put("descripcion", "Es una reunion para probar test");
		map.put("fecha", "17-11-2020");
		map.put("horaIni", "09:00");
		map.put("horaFin", "11:00");
		try {
			controller.guardarReunion(null, map);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
