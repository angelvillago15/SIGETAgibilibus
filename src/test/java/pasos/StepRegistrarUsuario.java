package pasos;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepRegistrarUsuario {
	@Given("^Todos los campos del formulario estan vacios$")
	public void comprobarCamposVacios () {
		
	}
	
	@Given ("^Introduzco los campos obligatorios <nombre de usuario>, el primer <e-mail> y la primera <contraseña>$")
	public void comprobarCamposObligatorios () {
		
	}
	
	@Given ("^He introducido la segunda <contraseña>$")
	public void comprobarCampoPwd1 () {
		
	}
	
	@Given ("^He introducido el segundo <e-mail>$")
	public void comprobarCampoMail1 () {
		
	}
	
	@When ("^Los campos de primera <contraseña> y segunda <contraseña> coinciden$")
	public void contraseñasIguales () {
		
	}
	
	@When ("^Los campos de primer <e-mail> y segundo <e-mail> coinciden$")
	public void mailsIguales () {
		
	}
	
	@Then ("^Los campos son correctos. Usuario registrado$")
	public void getUserPass () {
		
	}
	
	@When ("^Los campos de primera <contraseña> y segunda <contraseña> no coinciden$")
	public void contraseñasDistintas () {
		
	}
	
	
	@Then ("^Las contraseñas no coinciden. Mostrar mensaje de error <mensaje>$")
	public void error1 () {
		System.out.println("Las contraseñas no coinciden.");
	}
	
	@When ("^Los campos de primer <e-mail> y segundo <e-mail> no coinciden$")
	public void mailsDistintos () {
		
	}
	
	@Then ("^Los e-mails no coinciden. Mostrar mensaje de error <mensaje>$")
	public void error2 () {
		System.out.println("Los e-mails no coinciden.");
	}
	
	


	

}
