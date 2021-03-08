package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import definitions.Hook;

public class ModuloVuelo {
	
	String xpathOrigen = "//input[@placeholder='Ingresa desde dónde viajas']";
	String xpathCheckBox = "//input[@type = 'checkbox']";
	String xpathDestino = "//input[@placeholder='Ingresa hacia dónde viajas']";
	String xpathBuscar = "//*[text()='Buscar']";
	String xpathAvisoOrigen = "//*[@class='validation-msg' and text() = 'Ingresa un origen']";
	String xpathIda = "//input[@placeholder='Ida']";
	String xpathRegreso = "//input[@placeholder='Regreso']";
	String xpathSoloIda = "//span[@class = 'radio-label' and text() = 'Solo ida']";
	String xpathVuelos = "//span[text()='Siguiente']";
	String xpathBtnContinuar = "//em[@class='btn-text' and text()='Continuar']";
	String xpathTituloFinal = "//h2[text()='¡Falta poco! Completa tus datos y finaliza tu compra']";
	String xpathBtnComprar = "//em[@class='btn-text' and text()='Comprar sin asistencia']";
	String xpathPrimerLetrero = "//*[@class = 'validation-msg']";
	
	WebElement campo;
	List<WebElement> vuelos;
	
	public boolean verificarVisibilidadLetrero() {
		campo = Hook.navegador.findElement(By.xpath(xpathPrimerLetrero));
		if(campo.getCssValue("visibility").equalsIgnoreCase("visible")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clicComprar() {
		campo = Hook.navegador.findElement(By.xpath(xpathBtnComprar));
		campo.click();
		try {
			Thread.sleep(2000);
		}catch(Exception ex) {
			
		}
	}
	
	public String comprobarTituloFinal() {
		try {			
			Hook.navegador.findElement(By.xpath(xpathTituloFinal)).wait();
		}catch(Exception ex) {
			
		}		
		campo = Hook.navegador.findElement(By.xpath(xpathTituloFinal));
		return campo.getText();
	}
	
	public void seleccionarPrimerVuelo() {
		vuelos = Hook.navegador.findElements(By.xpath(xpathVuelos));
		campo = vuelos.get(0);
		campo.click();		
		try {
		Hook.navegador.findElement(By.xpath(xpathBtnContinuar)).wait();
		}catch(Exception ex) {
			
		}
		campo = Hook.navegador.findElement(By.xpath(xpathBtnContinuar));
		campo.click();
	}
	
	public void seleccionarSoloIda() {
		campo = Hook.navegador.findElement(By.xpath(xpathSoloIda));
		System.out.println(campo);
		campo.click();
	}
	
	public boolean verificarRegresoDeshabilitado(){
		campo = Hook.navegador.findElement(By.xpath(xpathRegreso));
		if(campo.getCssValue("background-color").equalsIgnoreCase("rgba(170, 170, 170, 1)")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void llenarOrigen() {
		try {
			Hook.navegador.findElement(By.xpath(xpathOrigen)).wait();
		}catch(Exception ex) {
				
		}
		campo = Hook.navegador.findElement(By.xpath(xpathOrigen));
		campo.sendKeys(Keys.TAB);
	}
	
	public void dejarOrigenVacio() {
		try {
		Hook.navegador.findElement(By.xpath(xpathOrigen)).wait();
		}catch(Exception ex) {
			
		}
		campo = Hook.navegador.findElement(By.xpath(xpathOrigen));
		campo.click();
		campo.sendKeys(Keys.BACK_SPACE);
		campo.sendKeys(Keys.TAB);
	}
	
	public void seleccionarNoHeDecididoFecha() {
		campo = Hook.navegador.findElement(By.xpath(xpathCheckBox));
		campo.sendKeys(Keys.SPACE);
	}
	
	public void llenarDestino() {
		campo = Hook.navegador.findElement(By.xpath(xpathDestino));
		campo.sendKeys("Mexico");
		try {
		Thread.sleep(2000);
		}
		catch(Exception ex) {
			
		}
		campo.sendKeys(Keys.TAB);
	}
	public void clicBotonBuscar() {
		campo = Hook.navegador.findElement(By.xpath(xpathBuscar));
		campo.click();
	}
	
	public boolean checarVisibilidad() {
		campo = Hook.navegador.findElement(By.xpath(xpathAvisoOrigen));
		if(campo.getCssValue("visibility").equalsIgnoreCase("visible")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checarEnabledCampos() {
		boolean enabled_1 = true;
		boolean enabled_2 = true;
		campo = Hook.navegador.findElement(By.xpath(xpathIda));
		if(campo.getCssValue("background-color").equalsIgnoreCase("rgba(170, 170, 170, 1)")) {
			enabled_1 = false;
		}
		campo = Hook.navegador.findElement(By.xpath(xpathRegreso));
		if(campo.getCssValue("background-color").equalsIgnoreCase("rgba(170, 170, 170, 1)")) {
			enabled_2 = false;
		}
		if(enabled_1 == false && enabled_2 == false) {
			return false;
		}
		else {
			return true;
		}
	}
}
