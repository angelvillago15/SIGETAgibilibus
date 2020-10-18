package pasos;
import com.agibilibus.SIGET.model.CalendarioManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsVisualizarCalendario {

	@Given("^Me autentico como usuario$")
	public void autenticarme() throws Throwable{
		CalendarioManager.autenticarme();
	}
	
	
	@When("^Estoy en mi pagina principal$")
	public void estoyEnMenuPrincipal() throws Throwable{
		CalendarioManager.estoyEnMenuPrincipal();
	}
	
	@Then("^Visualizo mi calendario semanal$")
	public void cargarTareasEnCalendario() throws Throwable{
		CalendarioManager.visualizarCalendario();
	}
	
}
