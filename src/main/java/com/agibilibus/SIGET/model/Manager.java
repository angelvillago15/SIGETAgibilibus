package com.agibilibus.SIGET.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.agibilibus.SIGET.dao.UserDAO;

@Component
public class Manager {
	@Autowired
	UserDAO userDAO;

	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}

	private static class ManagerHolder {
		static Manager singleton = new Manager();
	}

	private Manager() {
		//addUsuario(new Usuario("Carlos", "Rivas", 123, "a@a.com", "06", "10/05/1997", "carlos", "123", Rol.ADMIN));

	}

	public void addUsuario(Usuario user) {
		System.out.println("Añadiendo...");
		System.out.println(user.toString());
		userDAO.save(user);
		//userDAO.findAll();
	}

}
