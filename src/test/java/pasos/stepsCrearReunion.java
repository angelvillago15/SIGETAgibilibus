package pasos;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.agibilibus.SIGET.model.Manager;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepsCrearReunion {

	    
    @Given("^Estoy autenticado como usuario en el sistema con: <httpSession>, <userName>, <pwd>$")
    public void estoy_autenticado_en_el_sistema(HttpSession httpSession, String userName, String pwd) throws Throwable{
    	Manager.get().login(httpSession, userName, pwd);
    }
	@When("^Guardo una nueva reunion con los atributos <idReunion>, <titulo>, <descripcion>, <horaInicio>, <horaFin>, <organizador>, <asistentes>, <url>$")
	public void guardar_esa_reunion (int idReunion, String titulo, String descripcion, LocalDate horaInicio, LocalDate horaFin, Usuario organizador, List<Usuario> asistentes, String url) throws Throwable{
		Manager.get().guardarReunion(idReunion, titulo, descripcion, horaInicio, horaFin, organizador, asistentes, url);
	}
	
	@Then("^Actualizo mi calendario con la nueva reunion$")
	public void actualizar_mi_calendario_con_la_nueva_reunion()  throws Throwable{
		Manager.get().cargarCalendario();
	}
	

}
