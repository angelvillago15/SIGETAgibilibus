  
package pasos;
import javax.servlet.http.HttpSession;

import com.agibilibus.SIGET.model.*;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepsVisualizarCalendario {

	@Given("^Estoy autenticado como usuario en el sistema /.*/ /.*/ /.*/$")
	public void estoy_autenticado_como_usuario (HttpSession httpSession, String userName, String pwd) throws Throwable{
		Sesion.get().login(httpSession, userName, pwd);
		
		throw new PendingException();
	}
	
	
	@When("^Entro a la pantalla de calendario semanal$")
	public void visualizarCalendario() throws Throwable{
		//Manager.get().cargarCalendario();
	}
	
	@Then("^Veo mis reuniones de la semana$")
	public void cargarReuniones() throws Throwable{
		//Manager.get().cargarReuniones();
	}
	
}