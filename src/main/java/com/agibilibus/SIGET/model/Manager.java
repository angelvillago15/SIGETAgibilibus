package com.agibilibus.SIGET.model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.agibilibus.SIGET.dao.UserDAO;



@Component
public class Manager {
	@Autowired
	private UserDAO userdao;

	private ConcurrentHashMap<String, Usuario> connectedUsersByUserName;
	private ConcurrentHashMap<String, Usuario> connectedUsersByHttpSession;

	private Manager() {
		this.connectedUsersByUserName = new ConcurrentHashMap<>();
		this.connectedUsersByHttpSession = new ConcurrentHashMap<>();

	}

	private static class ManagerHolder {
		static Manager singleton = new Manager();
	}

	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}

	public Usuario login(HttpSession httpSession, String userName, String pwd) throws Exception {
		try {
			Optional<Usuario> optUser = userdao.findById(userName);

			if (optUser.isPresent()) {
				Usuario user = optUser.get();
				if (user.getPassword().equals(pwd)) {
					user.setHttpSession(httpSession);
					this.connectedUsersByUserName.put(userName, user);
					this.connectedUsersByHttpSession.put(httpSession.getId(), user);
					return user;
				}
			}
			throw new Exception("Credenciales inválidas");
		} catch (SQLException e) {
			throw new Exception("Credenciales inválidas");
		}
	}
	
	public void guardarReunion(int idReunion, String titulo, String descripcion, LocalDate horaInicio, LocalDate horaFin, Usuario organizador, List<Usuario> asistentes, String url) throws Exception {
		
		
	}
	
	
	public void cargarCalendario () {
	}
	
	public void cargarReuniones() {
		
	}

}