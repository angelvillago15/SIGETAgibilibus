  
package pasos;
import com.agibilibus.SIGET.model.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepsVisualizarCalendario {

	@Given("^Estoy autenticado como usuario en el sistema$")
	public void autenticar() throws Throwable{
		UsuarioManager.autenticar();
	}
	
	
	@When("^Entro a la pantalla de calendario semanal$")
	public void visualizarCalendario() throws Throwable{
		CalendarioManager.visualizarCalendario();
	}
	
	@Then("^Veo mis reuniones de la semana$")
	public void cargarReuniones() throws Throwable{
		CalendarioManager.cargarReuniones();
	}
	
}