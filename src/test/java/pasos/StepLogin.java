package pasos;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.agibilibus.SIGET.model.Manager;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepLogin {
	
	
	
	@Given("estoy registrado como usuario ")
	public void registro( ) {
		//Manager.registrarse();
	}
	
	@When("introduzco en el campo usuario <usuario> correctamente")
	public void introducirUsuario(String usu, String pwd, HttpSession httpSession) throws Exception {
		//Manager.login(httpSession,usu,pwd);
		
	}
	@When("introduzco contraseña <password> correctamente")
	public void introducirContraseña(String usu, String pwd, HttpSession httpSession) throws Exception {
		//Manager.login(httpSession,usu,pwd);
	}
	
	@When("pulso el boton de validar <boton>")
	public void usuarioPulsaBoton(String usu, String pwd) {
		//driver.getElement(By.name("login")).click();
		
	}
	
	@Then("voy a la pagina de inicio del sistema")
	public void mostrarPantallaInicio(String url) {
		//Manager.visualizaPaginaPrincipal();
		
	}
	
	@Then("Usuario es incorrecto, mostrar el mensaje <mensaje>")
	public void mostrarMensajeErrorUsu() {
		System.out.println("Error el usuario es incorrecto");
	}
	
	@Then("contraseña es correcta, mostrar el mensaje <mensaje>")
	public void mostrarMensajeErrorPwd() {
	
		System.out.println("Error la contraseña es incorrecto");
	}
	

	
}
