package pasos;
import com.agibilibus.SIGET.model.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsVisualizarCalendario {

	@Given("^Estoy autenticado como usuario en el sistema$")
	public Usuario autenticar(String usuario, String pwd) throws Throwable{
		return UsuarioManager.autenticar(usuario, pwd);
	}
	
	
	@When("^Entro a la pantalla de calendario semanal$")
	public void visualizarCalendario() throws Throwable{
		CalendarioManager.visualizarCalendario();
	}
	
	@Then("^Veo mis reuniones de la semana$")
	public void cargarReuniones(Usuario usuario, Calendario c) throws Throwable{
		CalendarioManager.cargarReuniones(usuario, c);
	}
	
}
