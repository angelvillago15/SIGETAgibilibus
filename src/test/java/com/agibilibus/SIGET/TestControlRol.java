package com.agibilibus.SIGET;

import com.agibilibus.SIGET.controller.Controller;
import com.agibilibus.SIGET.dao.UserDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestControlRol {

	Controller cont = new Controller();

	@Autowired
	private UserDAO userdao;

	@Test
	public void testUsuarioConRol() {
		MockHttpSession session = new MockHttpSession();

		session.setAttribute("user", userdao.findById("carlos").get());
		Assert.assertNotNull(cont.getRol(session));

	}
	
	@Test
	public void testUsuarioAdmin() {
		MockHttpSession session = new MockHttpSession();

		session.setAttribute("user", userdao.findById("carlos").get());
		Assert.assertEquals("{\"rol\":\"admin\"}",cont.getRol(session));
		
	}

}
