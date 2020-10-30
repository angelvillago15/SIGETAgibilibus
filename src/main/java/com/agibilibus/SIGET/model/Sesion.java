package com.agibilibus.SIGET.model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.agibilibus.SIGET.dao.UserDAO;

public class Sesion implements Serializable {

	@Autowired
	private UserDAO userdao;
	private Usuario user;
	private HttpSession httpSession;

	private ConcurrentHashMap<String, Usuario> connectedUsersByUserName;
	private ConcurrentHashMap<String, Usuario> connectedUsersByHttpSession;

	private Sesion() {
		this.connectedUsersByUserName = new ConcurrentHashMap<>();
		this.connectedUsersByHttpSession = new ConcurrentHashMap<>();
	}

	private Sesion(Usuario user, HttpSession sesion) {
		super();
		this.user = user;
		this.httpSession = sesion;

	}

	public void login(HttpSession httpSession, String userName, String pwd) throws Exception {
		try {
			Optional<Usuario> optUser = userdao.findById(userName);

			if (optUser.isPresent()) {
				Usuario user = optUser.get();
				if (user.getPassword().equals(pwd)) {
					Sesion sesion = new Sesion(user, httpSession);
					this.connectedUsersByUserName.put(userName, user);
					this.connectedUsersByHttpSession.put(httpSession.getId(), user);
					this.user = user;
					sesion.getHttpSession().setAttribute("user", user);

				}
			}
			throw new Exception("Credenciales inválidas");
		} catch (SQLException e) {
			throw new Exception("Credenciales inválidas");
		}
	}

	public Usuario logout(HttpSession httpSession, String userName) {
		return user;

	}

	private static class SesionHolder {
		static Sesion singleton = new Sesion();
	}

	public static Sesion get() {
		return SesionHolder.singleton;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}

	public HttpSession getHttpSession() {
		return httpSession;
	}
}
