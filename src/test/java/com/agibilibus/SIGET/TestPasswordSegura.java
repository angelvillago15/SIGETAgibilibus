package com.agibilibus.SIGET;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPasswordSegura {
	Controller cont = new Controller();
	@Autowired
	UserDAO userdao;

	@Test
	public void testPasswordEncriptadaRegister()
	        throws  NoSuchAlgorithmException, JSONException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userCompletName", "Prueba");
		map.put("userName", "Prueba");
		map.put("userApellidos", "Prueba");
		map.put("userDate", "1999-11-10");
		map.put("userDni", "Prueba");
		map.put("userTelf", 666);
		map.put("userMail", "Prueba");
		map.put("pwd1", "contraseña");
		cont.register(null, map);
		assertNotEquals(map.get("pwd1"),userdao.findById("Prueba").get().getPassword());

	}

}
