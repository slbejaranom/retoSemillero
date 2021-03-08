package definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.ModuloVueloSteps;

import net.thucydides.core.annotations.Steps;

public class ModuloVueloDefinitions {
	
	@Before 
	public void inicializar() {
		Hook.initDriver();
		Hook.navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Steps
	ModuloVueloSteps moduloVueloSteps;

	@Given("^Dejar el origen vacio$")
	public void dejar_el_origen_vacio() {
	    // Write code here that turns the phrase above into concrete actions
		moduloVueloSteps.dejarCampoOrigenVacio();
	    
	}

	@Given("^seleccionar casilla de no he decidido la fecha$")
	public void seleccionar_casilla_de_no_he_decidido_la_fecha() {
	    // Write code here that turns the phrase above into concrete actions
	    moduloVueloSteps.seleccionarCasillaSinFecha();
	}

	@When("^Clic en buscar$")
	public void clic_en_buscar() {
	    // Write code here that turns the phrase above into concrete actions
		moduloVueloSteps.llenarCampoDestino();
		moduloVueloSteps.clicEnBuscar();	    
	}

	@Then("^Validar que salga el letrero$")
	public void validar_que_salga_el_letrero() {
	    // Write code here that turns the phrase above into concrete actions	    
	    Assert.assertEquals(true,moduloVueloSteps.esVisible());
	}
	
	//PRUEBA 2
	
	@Given("^Oprimir casilla todavia no he decidido fecha$")
	public void oprimir_casilla_todavia_no_he_decidido_fecha() {
	    // Write code here that turns the phrase above into concrete actions
		moduloVueloSteps.seleccionarCasillaSinFecha();
	}

	@Then("^Validar que los campos queden disabled$")
	public void validar_que_los_campos_queden_disabled() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(false, moduloVueloSteps.checarEnabled());
	}
	
	//PRUEBA 3
	
	@Given("^Llenar origen$")
	public void llenar_origen() {
	    moduloVueloSteps.llenarOrigen();
	    
	}

	@Given("^Llenar destino$")
	public void llenar_destino() {
	    // Write code here that turns the phrase above into concrete actions
	    moduloVueloSteps.llenarCampoDestino();
	}

	@When("^Usuario oprima solo ida$")
	public void usuario_oprima_solo_ida() {
	    // Write code here that turns the phrase above into concrete actions
	    moduloVueloSteps.seleccionarSoloIda();
	}

	@Then("^verificar regreso deshabilitado$")
	public void verificar_regreso_deshabilitado() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(false, moduloVueloSteps.verificarRegresoDeshabilitado());
	}
	
	//Prueba 4
	
	@Given("^Llenar bien formulario vuelo$")
	public void llenar_bien_formulario_vuelo() {
	    // Write code here that turns the phrase above into concrete actions
	    moduloVueloSteps.llenarOrigen();
	    moduloVueloSteps.llenarCampoDestino();
	    moduloVueloSteps.seleccionarCasillaSinFecha();
	    moduloVueloSteps.clicEnBuscar();
	}

	@When("^usuario seleccione vuelo$")
	public void usuario_seleccione_vuelo() {
	    // Write code here that turns the phrase above into concrete actions
	    moduloVueloSteps.seleccionarPrimerVuelo();
	    try {
	    	Thread.sleep(10000);
	    }catch(Exception ex) {
	    	
	    }
	}

	@Then("^verificar letrero final$")
	public void verificar_letrero_final() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals("¡Falta poco! Completa tus datos y finaliza tu compra",moduloVueloSteps.obtenerTituloFinal());
	}
	
	@Given("^dar clic a comprar sin asistencia$")
	public void dar_clic_a_comprar_sin_asistencia() {
	    // Write code here that turns the phrase above into concrete actions
		moduloVueloSteps.llenarOrigen();
	    moduloVueloSteps.llenarCampoDestino();
	    moduloVueloSteps.seleccionarCasillaSinFecha();
	    moduloVueloSteps.clicEnBuscar();
	    moduloVueloSteps.seleccionarPrimerVuelo();
	    try {
	    	Thread.sleep(10000);
	    }catch(Exception ex) {
	    	
	    }
	    moduloVueloSteps.clickEnComprar();
	}

	@Then("^verificar por lo menos un letrero$")
	public void verificar_por_lo_menos_un_letrero() {
	    // Write code here that turns the phrase above into concrete actions
		try {
		Thread.sleep(3000);
		}
		catch(Exception ex) {
			
		}
	    Assert.assertEquals(true, moduloVueloSteps.verificarLetrero());
	}


	
	@After 
	public void pruebasFinalizadas() {
		Hook.navegador.close();
		Hook.navegador.quit();
	}
}
