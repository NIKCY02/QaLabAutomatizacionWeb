package com.nttdata.steps;
import com.nttdata.page.ProdMyStorePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.nttdata.core.DriverManager.screenShot;


public class ProdMyStoreStep {

    private WebDriver driver;
    private WebDriverWait wait;
    public ProdMyStoreStep(WebDriver driver) {
        this.driver = driver;
    }


    public void openLoginPage() {
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        WebElement Inicio = driver.findElement(ProdMyStorePage.IniciarSesion);
        Inicio.click();
    }

    public void typeUser(String user) {
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        WebElement inputUsuario = driver.findElement(ProdMyStorePage.Usuario);
        inputUsuario.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

    }

    public void typePassword(String password) {
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        WebElement inputClave = driver.findElement(ProdMyStorePage.Password);
        inputClave.sendKeys(password);
    }

    public void login() {
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
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
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        WebElement elementoSeleccionado;

        switch(catego){
            case "CLOTHES":
                elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoCategoriaClothes);
                elementoSeleccionado.click();
                if (subcatego.equals("MEN")){
                    elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoSubcategoriaMen);
                    elementoSeleccionado.click();
                    screenShot();
                } else if(subcatego.equals("WOMEN")){
                    elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoSubcategoriaWomen);
                    elementoSeleccionado.click();
                    screenShot();
                } else {
                    System.out.println("No existe la subcategoría");
                    screenShot();
                    driver.quit();
                    driver = null;
                }
                break;

            case "ACCESORIOS":
                elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoCategoriaAccesorios);
                elementoSeleccionado.click();
                if (subcatego.equals("STATIONERY")){
                    elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoSubcategoriaStationery);
                    elementoSeleccionado.click();
                    screenShot();
                } else if(subcatego.equals("HOME_ACCESSORIES")){
                    elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoSubcategoriaHome_Accessories);
                    elementoSeleccionado.click();
                    screenShot();
                } else {
                    System.out.println("No existe la subcategoría");
                    screenShot();
                    driver.quit();
                    driver = null;
                }
                break;

            case "ART":
                elementoSeleccionado = driver.findElement(ProdMyStorePage.IngresoCategoriaArt);
                elementoSeleccionado.click();
                if (!subcatego.isEmpty()){
                    System.out.println("No tiene subcategoría");
                    screenShot();
                    driver.quit();
                    driver = null;
                }else{
                screenShot();
            }
                break;

            default:
                System.out.println("No existe la categoría");
                screenShot();
                driver.quit();
                driver = null;
                throw new RuntimeException("El test se detuvo porque la Categoría no existe");
                //break;

        }

    }

    public void SeleccionaProductoyCantidad(int unidad){
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        WebElement producto = driver.findElement(ProdMyStorePage.SeleccionoPrimerProducto);
        producto.click();
        WebElement cantidad = driver.findElement(ProdMyStorePage.Elijo2Unidades);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", cantidad);
        cantidad.sendKeys(String.valueOf(unidad));
    }

    public void ValidacionProducto() throws InterruptedException{
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement agregar = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ProdMyStorePage.AgregoalcarritodeCompra)));
        agregar.click();
        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    public void ValidacionPrecio(){
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        WebElement precioTot = driver.findElement(ProdMyStorePage.CalcularCompra);
        WebElement precio = driver.findElement(ProdMyStorePage.PrecioProducto);
        WebElement cantidad = driver.findElement(ProdMyStorePage.CantidadProducto);
        double Precio = Double.parseDouble(precio.getText().trim().split(" ")[0].replace(",","."));
        double Cantidad = Double.parseDouble(cantidad.getText().trim().split(" ")[0].replace(",","."));
        double PrecioTot = Double.parseDouble(precioTot.getText().trim().split(" ")[0].replace(",","."));
        if(Precio * Cantidad == PrecioTot){
            System.out.println("Calculo correcto");
            screenShot();
        }else {
            System.out.println("Calculo incorrecto");
            screenShot();
            driver.quit();
            driver = null;
        }
    }

    public void FinalizoCompra() throws InterruptedException{
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        //WebElement finalizarCompra = driver.findElement(ProdMyStorePage.FinalizarCompraBtn);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement finalizarCompra = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ProdMyStorePage.FinalizarCompraBtn)));
        finalizarCompra.click();
        Thread.sleep(5000);
    }

    public void TituloCarrito(){
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera hasta 10 segundos
        WebElement tituloCarrito = wait.until(ExpectedConditions.visibilityOfElementLocated(ProdMyStorePage.TituloCarrito));
        String titulo = tituloCarrito.getText();
        System.out.println("El título del carrito es: " + titulo); // Imprime para verificar

        /*WebElement tituloCarrito = driver.findElement(ProdMyStorePage.TituloCarrito);
        String titulo = tituloCarrito.getText();*/
    }

    public void ValidacionPrecioCarrito(){
        if (driver == null){
            throw new RuntimeException("El WebDrive se cerro, no se ejecutarán más test");
        }
        WebElement precioTotal = driver.findElement(ProdMyStorePage.CalculoPrecioTotal);
        WebElement precio = driver.findElement(ProdMyStorePage.CantPrecio);
        WebElement cantidad = driver.findElement(ProdMyStorePage.CantProducto);
        double Precio = Double.parseDouble(precio.getText().trim().split(" ")[0].replace(",","."));
        double Cantidad = Double.parseDouble(cantidad.getAttribute("value").trim().split(" ")[0].replace(",","."));
        double PrecioTotal = Double.parseDouble(precioTotal.getText().trim().split(" ")[0].replace(",","."));
        if(Precio * Cantidad == PrecioTotal){
            System.out.println("Calculo correcto");
            screenShot();
        }else {
            System.out.println("Calculo incorrecto");
            screenShot();
            driver.quit();
            driver = null;
        }

    }
}
