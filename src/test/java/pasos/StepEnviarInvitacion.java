package pasos;

import java.util.List;

import org.joda.time.DateTime;

import com.agibilibus.SIGET.model.Invitacion;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepEnviarInvitacion {

	@Given("he rellenado el formulario para crear la reunion")
	public void crearReunion(int idReunion, String titulo, String descripcion, DateTime horaInicio, DateTime horaFin,
	        Usuario organizador, String[] correosAsistentes, String url) throws Exception {
		//Reunion.get().guardarReunion(idReunion, titulo, descripcion, horaInicio, horaFin, organizador, correosAsistentes, url);
	}

	@When("envio la invitacion a los asistentes <asistentes> ")
	public void enviarInvitacion() {
		//Invitacion.get().enviarInvitacion();
	}

	@Then("me aparece una notificacion ")
	public void mostrarNotificacion(Reunion reunion, List<Usuario> asistentes) {
		// Manager.get().mostrarNotificacion(reunion, asistentes);
	}

	@Then("respondo invitación ")
	public void responderInvitacion(Reunion reunion, Usuario asistente) {
		// Manager.get().responderInvitacion(reunion, asistente);
	}

	@Then(" muestra mensaje de error <mensaje>")
	public void muestraMensaje() {
		System.out.println("Error no se ha podido enviar invitacion");
	}
}
