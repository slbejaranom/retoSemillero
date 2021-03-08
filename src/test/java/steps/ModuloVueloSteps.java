package steps;

import net.thucydides.core.annotations.Step;
import pageObjects.ModuloVuelo;

public class ModuloVueloSteps {
	
	ModuloVuelo moduloVuelo = new ModuloVuelo();
	
	@Step
	public void dejarCampoOrigenVacio() {
		moduloVuelo.dejarOrigenVacio();
	}
	@Step
	public void seleccionarCasillaSinFecha() {
		moduloVuelo.seleccionarNoHeDecididoFecha();
	}
	@Step
	public void llenarCampoDestino() {
		moduloVuelo.llenarDestino();		
	}
	@Step
	public void clicEnBuscar() {
		moduloVuelo.clicBotonBuscar();
	}
	@Step
	public boolean esVisible() {
		return moduloVuelo.checarVisibilidad();
	}
	@Step
	public boolean checarEnabled() {
		return moduloVuelo.checarEnabledCampos();
	}
	@Step
	public void llenarOrigen() {
		moduloVuelo.llenarOrigen();
	}
	@Step
	public void seleccionarSoloIda() {
		moduloVuelo.seleccionarSoloIda();
	}
	@Step
	public boolean verificarRegresoDeshabilitado() {
		return moduloVuelo.verificarRegresoDeshabilitado();
	}
	@Step
	public void seleccionarPrimerVuelo() {
		moduloVuelo.seleccionarPrimerVuelo();
	}
	@Step
	public String obtenerTituloFinal() {
		return moduloVuelo.comprobarTituloFinal();
	}
	@Step
	public void clickEnComprar()
	{
		moduloVuelo.clicComprar();
	}
	@Step
	public boolean verificarLetrero() {
		return moduloVuelo.verificarVisibilidadLetrero();
	}
}
