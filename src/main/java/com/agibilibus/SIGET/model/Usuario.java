package com.agibilibus.SIGET.model;
import java.util.Calendar;
import java.util.Date;




public class Usuario {
	
	private String Nombre;
	private String Apellidos;
	private int Telefono;
	private String email;
	private String DNI;
	private Calendar date = Calendar.getInstance();
	private String User;
	private String Password;
	private Rol rol;
	
	
	public Usuario(String nombre, String apellidos, int telefono, String email, String dNI, Calendar date, String user,
			String password, Rol rol) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		Telefono = telefono;
		this.email = email;
		DNI = dNI;
		this.date =date; //calendar1.get(Calendar.DATE);
		User = user;
		Password = password;
		this.rol = rol;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellidos() {
		return Apellidos;
	}


	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}


	public String getUser() {
		return User;
	}


	public void setUser(String user) {
		User = user;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(String nombre_Rol) {
		if(nombre_Rol.equals("Admin"))
			this.rol = rol.ADMIN;
		else
			this.rol=rol.USUARIO;
	}


	@Override
	public String toString() {
		return "Usuario [Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Telefono=" + Telefono + ", email=" + email
				+ ", DNI=" + DNI + ", date=" + date + ", User=" + User + ", Password=" + Password + ", rol=" + rol
				+ "]";
	}
}