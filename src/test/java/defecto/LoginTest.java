package defecto;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.fail;

import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.agibilibus.SIGET.dao.UserDAO;

import junit.framework.Assert;

class LoginTest {
	
	@Autowired
	//HttpSession sesion;
	UserDAO dao;
	
	@Test
	void test() {
		Assert.assertNotNull(dao.existsById("pepe"));
	}

}
