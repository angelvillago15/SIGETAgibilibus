package com.agibilibus.siget;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEditarReunion {

 private WebDriver driver;

 @Before
 public void setUp() {

  System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get(" https://sigetagibilibus.herokuapp.com/editAccount.html");

 }

 @Test
 public void testEditarCuenta() {

  WebElement nombreUsuario = driver.findElement(By.id("Nusername"));
  WebElement contraseña = driver.findElement(By.id("Npass"));
  WebElement nuevaContraseña = driver.findElement(By.id("CNpass"));
  WebElement btnEditar = driver.findElement(By.id("edit"));

  nombreUsuario.sendKeys("Rodolfa");
  contraseña.sendKeys("Hola1234");
  nuevaContraseña.sendKeys("Hola1234");
  btnEditar.click();
  
  Alert alerta = driver.switchTo().alert();
  alerta.accept();

 }

 @Test
 public void EliminarCuenta() {
  WebElement btnEliminar = driver.findElement(By.id("remove"));

  btnEliminar.click();

  String expectedUrl = "https://sigetagibilibus.herokuapp.com/deleteAccount.html";
  String actualUrl = driver.getCurrentUrl();
  assertEquals(actualUrl, expectedUrl);
  
  WebElement opcion = driver.findElement(By.id("cause"));
  WebElement comentario = driver.findElement(By.id("comment"));
  
  comentario.sendKeys("No me funciona bien");
  opcion.click();
  opcion.sendKeys("Otro");
  
  WebElement btnRemove = driver.findElement(By.id("remove"));
  btnRemove.click();

  Alert alerta = driver.switchTo().alert();
  alerta.accept();

 }

 @After
 public void tearDown() {
 // driver.quit();
 }
}
