package pasos;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.agibilibus.SIGET.model.Sesion;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepLogin {

	@Given("estoy registrado como usuario ")
	public void registro() {
		Usuario.get().register();
	}

	@When("introduzco en el campo usuario <usuario> correctamente")
	public void introducirUsuario(String usu, String pwd, HttpSession httpSession) throws Exception {
		Sesion.get().login(httpSession, usu, pwd);

	}

	@When("introduzco contraseña <password> correctamente")
	public void introducirContraseña(String usu, String pwd, HttpSession httpSession) throws Exception {
		Sesion.get().login(httpSession, usu, pwd);
	}

	@Then("Usuario es incorrecto, mostrar el mensaje <mensaje>")
	public void mostrarMensajeErrorUsu() {
		System.out.println("Error el usuario es incorrecto");
	}

	@Then("contraseña es incorrecta, mostrar el mensaje <mensaje>")
	public void mostrarMensajeErrorPwd() {

		System.out.println("Error la contraseña es incorrecto");
	}

}
