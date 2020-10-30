package pasos;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;

import com.agibilibus.SIGET.model.Manager;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepRegistrarUsuario {

	@Given("un usuario que ha pulsado el boton Registrarme ")

	@When("cuando introduzco en el campo nombre de usuario <nombre de usuario>")
	public void introducirNombre(String nombreUsuario) throws Exception {
		Manager.get().register(nombreUsuario);
	}
	
	@When("cuando introduzco en el campo contraseña <contraseña>")
	
	
	@When("cuando introduzco en el campo email <email>")
	
	@When("cuando introduzco en el campo validar la misma <contraseña>")

	
	@Then("Se añade mi nuevo usuario al sistema")

	
	@Then("Las contraseñas no coinciden. Mostrar el mensaje <mensaje>")
	public void mostrarMensajeErrorPwd() {	
		System.out.println("Las contraseñas no coinciden");
	}

	

}
