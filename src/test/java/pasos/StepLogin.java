package pasos;

import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepLogin {
	
	Usuario us;
	
	@Given("estoy registrado como usuario ")
	public void registro( ) {
		UsuarioManager.registrarse();
	}
	
	@When("introduzco en el campo usuario <usuario> correctamente")
	public void introducirUsuario(String usu, String pwd) {
		UsuarioManager.IniciarSesion(usu, pwd);
	}
	@When("introduzco contraseña <password> correctamente")
	public void introducirContraseña(String usu, String pwd) {
		UsuarioManager.IniciarSesion(usu, pwd);
	}
	
	@When("pulso el boton de validar <boton>")
	public void usuarioPulsaBoton(String usu, String pwd) {
		
		
	}
	
	@Then("voy a la pagina de inicio del sistema")
	public void mostrarPantallaInicio() {
		
	}

	
}
