package com.agibilibus.SIGET.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.agibilibus.SIGET.model.Invitacion;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Sesion;
import com.agibilibus.SIGET.model.Usuario;

@RestController
public class Controller {
	private static String error = "error";
	private static String message = "message";

	@GetMapping("/")
	public ModelAndView inicio(ModelMap model) {
		return new ModelAndView("redirect:/Login.html", model);
	}

	@PostMapping("/login")
	public void login(HttpSession session, @RequestBody Map<String, Object> credenciales) throws Exception {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			JSONObject jso = new JSONObject(credenciales);
			String userName = jso.getString("userName");
			byte[] datosDesencriptados = md.digest(jso.getString("pwd").getBytes(StandardCharsets.UTF_8));
			String pwd = new String(datosDesencriptados);
			Sesion.get().login(session, userName, pwd);
		} catch (Exception e) {
			throw new Exception(e);

		}
	}

	@PostMapping("/register")
	public String register(HttpSession session, @RequestBody Map<String, Object> credenciales)
	        throws NoSuchAlgorithmException, JSONException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		JSONObject jso = new JSONObject(credenciales);
		String userCompletName = jso.getString("userCompletName");
		String userName = jso.getString("userName");
		String userApellidos = jso.getString("userApellidos");
		String userDate = jso.getString("userDate");
		String userDni = jso.getString("userDni");
		int userTelf = Integer.parseInt(jso.getString("userTelf"));
		String userMail = jso.getString("userMail");
		byte[] datosDesencriptados = md.digest(jso.getString("pwd1").getBytes(StandardCharsets.UTF_8));
		String pwd1 =new String(datosDesencriptados);

		DateTime fecha = DateTime.parse(userDate);

		JSONObject resultado = new JSONObject();

		try {
			Usuario.get().crearUsuario(pwd1, userCompletName, userName, userApellidos, fecha, userDni, userTelf,
			        userMail);
			resultado.put("type", "OK");

		} catch (Exception e) {
			resultado.put("type", error);
			resultado.put(message, e.getMessage());
		}

		return resultado.toString();
	}

	@PostMapping("/nuevaTarea")
	public void guardarReunion(HttpSession session, @RequestBody Map<String, Object> datosReunion) throws Exception {
		JSONObject jso = new JSONObject(datosReunion);
		String titulo = jso.getString("nombre");
		String descripcion = jso.getString("descripcion");
		String[] fecha = jso.getString("fecha").split("-");
		String[] horaIni = jso.getString("horaInicio").split(":");
		String[] horaFin = jso.getString("horaFin").split(":");
		DateTime horaI = new DateTime(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]),
		        Integer.parseInt(fecha[2]), Integer.parseInt(horaIni[0]), Integer.parseInt(horaIni[1]),
		        DateTimeZone.forID("Europe/Madrid"));
		DateTime horaF = new DateTime(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]),
		        Integer.parseInt(fecha[2]), Integer.parseInt(horaFin[0]), Integer.parseInt(horaFin[1]),
		        DateTimeZone.forID("Europe/Madrid"));
		Usuario organizador = (Usuario) session.getAttribute("user");
		String url = jso.getString("url");
		String[] correosAsistentes = ((jso.getString("correos")).replace(" ", "")).split(",");
		Reunion.get().guardarReunion(titulo, descripcion, horaI, horaF, organizador, correosAsistentes, url);

	}

	@PostMapping("/loadReunion")
	public String loadReunion(HttpSession session, @RequestBody Map<String, Object> loadReunion) throws Exception {
		JSONObject jso = new JSONObject(loadReunion);
		String id = jso.getString("id");
		return Reunion.get().loadReunion(id).toString();
	}

	@PostMapping("/getReuniones")
	public String getReuniones(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("user");
		return Reunion.get().getReuniones(usuario).toString();
	}
	
	@PostMapping("/getRol")
	public String getRol(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("user");
		JSONObject jso = new JSONObject();
		jso.put("rol", usuario.getRol());
		return jso.toString();
	}

	@PostMapping("/recibirInvitacion")
	public String getInvitaciones(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("user");
		JSONObject jso = new JSONObject();
		jso.put("invitaciones", Invitacion.get().recibirInvitacion(usuario));
		return jso.toString();
	}

	@PostMapping("/nuevaInvitacion")
	public void nuevaInvitacion(HttpSession session, @RequestBody Map<String, Object> correos) throws Exception {
		JSONObject jso = new JSONObject(correos);
		String id = jso.getString("id");
		String[] correosAsistentes = ((jso.getString("correos")).replace(" ", "")).split(",");
		Invitacion.get().enviarInivitacion(id, correosAsistentes);

	}
	
	@PostMapping("/modifyUser")
	public void modificar(HttpSession session, @RequestBody Map<String, Object> credenciales)
	        throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
	        IllegalBlockSizeException, BadPaddingException, JSONException {
		/*JSONObject jso = new JSONObject(credenciales);
		String userName = jso.getString("userName");
		String userApellidos = jso.getString("userApellidos");
		String userDate = jso.getString("userDate");
		String userDni = jso.getString("userDni");
		int userTelf = Integer.parseInt(jso.getString("userTelf"));
		String userMail = jso.getString("userMail");
		String pwd1 = jso.getString("pwd1");
		String rol = jso.getString("rol"); 

		DateTime fecha = DateTime.parse(userDate);*/
		
		JSONObject resultado = new JSONObject();

		/*try {
			Usuario.get().modificarUsuario(u, pwd1, userName, userApellidos, fecha, userDni, userTelf,
			        userMail, rol);
			resultado.put("type", "OK");

		} catch (Exception e) {
			resultado.put("type", error);
			resultado.put(message, e.getMessage());
		}*/

		
	}
}
