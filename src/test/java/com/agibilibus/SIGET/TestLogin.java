package com.agibilibus.SIGET;

import static org.junit.jupiter.api.Assertions.*;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.agibilibus.SIGET.dao.UserDAO;


class LoginTest {
	
	@Autowired
	//HttpSession sesion;
	UserDAO dao;
	
	@Test
	void test() {
		Assert.assertNotNull(dao.existsById("pepe"));
	}

}
