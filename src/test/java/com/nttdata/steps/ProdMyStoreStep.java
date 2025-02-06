package com.nttdata.steps;
import com.nttdata.page.ProdMyStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProdMyStoreStep {

    private WebDriver driver;
    private WebDriverWait wait;
    public ProdMyStoreStep(WebDriver driver) {
        this.driver = driver;
    }


    public void openLoginPage() {
        WebElement Inicio = driver.findElement(ProdMyStorePage.IniciarSesion);
        Inicio.click();
    }

    public void typeUser(String user) {
        WebElement inputUsuario = driver.findElement(ProdMyStorePage.Usuario);
        inputUsuario.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

    }

    public void typePassword(String password) {
        WebElement inputClave = driver.findElement(ProdMyStorePage.Password);
        inputClave.sendKeys(password);
    }

    public void login() {
        WebElement inicioSesionBtn = driver.findElement(ProdMyStorePage.InicioSesionBtn);
        inicioSesionBtn.click();
            /*WebElement texto = driver.findElement(ProdMyStorePage.MensajeInicio);
            if (texto.getText().trim().equals("Error de autenticación.")){
                System.out.println("Logueo fallido");
                driver.quit();
            } else {
                System.out.println("Logueo exitoso");
            }*/
    }

    public void SeleccionaCategoriaySubcategoria(String catego, String subcatego){
        WebElement elementoSeleccionado;

        switch(catego){
            case "CLOTHES":
                elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoCategoriaClothes);
                elementoSeleccionado.click();
                if (subcatego.equals("MEN")){
                    elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoSubcategoriaMen);
                    elementoSeleccionado.click();
                } else if(subcatego.equals("WOMEN")){
                    elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoSubcategoriaWomen);
                    elementoSeleccionado.click();
                } else {
                    System.out.println("No existe la categoría");
                    driver.quit();
                }
                break;

            case "ACCESORIOS":
                elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoCategoriaAccesorios);
                elementoSeleccionado.click();
                if (subcatego.equals("STATIONERY")){
                    elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoSubcategoriaStationery);
                    elementoSeleccionado.click();
                } else if(subcatego.equals("HOME_ACCESSORIES")){
                    elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoSubcategoriaHome_Accessories);
                    elementoSeleccionado.click();
                } else {
                    System.out.println("No existe la subcategoría");
                    driver.quit();
                }
                break;

            case "ART":
                elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoCategoriaArt);
                elementoSeleccionado.click();
                if (!subcatego.isEmpty()){
                    System.out.println("No tiene subcategoría");
                    driver.quit();
                }
                break;

            default:
                System.out.println("No existe la categoría");
                driver.quit();
                break;


        }

    }

    public void SeleccionaProductoyCantidad(int unidad){
        WebElement producto = driver.findElement(ProdMyStorePage.SeleccionoPrimerProducto);
        producto.click();
        WebElement cantidad = driver.findElement(ProdMyStorePage.Elijo2Unidades);
        cantidad.sendKeys(String.valueOf(unidad));
    }



    /*public void User(String user){
        WebElement userInputElement = driver.findElement(ProdMyStorePage.Usuario);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProdMyStorePage.InicioSesionBtn));
    }

    public void Password(String password){
        this.driver.findElement(ProdMyStorePage.Password).sendKeys(password);
    }*/

    /*public void login(){
        this.driver.findElement(ProdMyStorePage.InicioSesionBtn).click();
    }*/


}
