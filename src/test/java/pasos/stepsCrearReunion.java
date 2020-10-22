package pasos;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.agibilibus.SIGET.model.Manager;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepsCrearReunion {

	    
    @Given("^Estoy autenticado en el sistema$")
    public void estoy_autenticado_en_el_sistema(HttpSession httpSession, String userName, String pwd) throws Throwable{
    	Manager.get().login(httpSession, userName, pwd);
    }
	@When("^Pulso en el boton crear reunion$")
	public void pulsar_boton_crear_reunion()  throws Throwable{
		
	}
	
	@And("^Confirmo los campos rellenados para crear una reunion$")
	public void confirmar_campos_rellenados_para_crear_una_reunion() throws Throwable{
		
	}
	@Then("^Guardo esa reunion$")
	public void guardar_esa_reunion (int idReunion, String titulo, String descripcion, LocalDate horaInicio, LocalDate horaFin, Usuario organizador, List<Usuario> asistentes, String url) throws Throwable{
		Manager.get().guardarReunion(idReunion, titulo, descripcion, horaInicio, horaFin, organizador, asistentes, url);
	}
	
	@And("^Actualizo mi calendario con la nueva reunion$")
	public void actualizar_mi_calendario_con_la_nueva_reunion()  throws Throwable{
		
	}
	

}
