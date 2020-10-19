package pasos;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepLogin {
		
	@Given("estoy registrado como usuario ")
	public Usuario registro(String us, String pwd ) {
		return Usuario;
	}
	
	@When("introduzco en el campo usuario <usuario> correctamente")
	public void introducirUsuario() {
		
	}
	@When("introduzco contraseña <password> correctamente")
	public void introducirContraseña() {
		
	}
	
	@When("pulso el boton de validar <boton>")
	public void usuarioPulsaBoton() {
		
	}
	
	@Then("voy a la pagina de inicio del sistema")
	public void mostrarPantallaInicio() {
		
	}

	
}
