package com.nttdata.stepsdefinitions;
import com.nttdata.page.ProdMyStorePage;
import com.nttdata.steps.ProdMyStoreStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;
public class ProdMyStoreStepDef {

    private WebDriver driver;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        ProdMyStoreStep loginSteps = new ProdMyStoreStep(driver);
        loginSteps.openLoginPage(); // Método para hacer clic en "Iniciar Sesión"
        loginSteps.typeUser(user); // Ingresar usuario
        loginSteps.typePassword(password); // Ingresar clave
        loginSteps.login(); // Hacer clic en el botón "Iniciar sesión"
        screenShot(); // Tomar captura de pantalla
    }

    @Cuando("navego a la categoria {string} y luego a la subcategoria {string}")
    public void navegoALaCategoriaYLuegoALaSubcategoria(String categoria, String subcategoria) {
        ProdMyStoreStep elementoSeleccionado = new ProdMyStoreStep(driver);
        elementoSeleccionado.SeleccionaCategoriaySubcategoria(categoria,subcategoria);

    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int productos) {
        ProdMyStoreStep productoSeleccionado = new ProdMyStoreStep(driver);
        productoSeleccionado.SeleccionaProductoyCantidad(productos);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() throws InterruptedException{
        ProdMyStoreStep productoAgregado = new ProdMyStoreStep(driver);
        productoAgregado.ValidacionProducto();
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        ProdMyStoreStep validarprecio = new ProdMyStoreStep(driver);
        validarprecio.ValidacionPrecio();

    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() throws InterruptedException{
        ProdMyStoreStep finalizarCompra = new ProdMyStoreStep(driver);
        finalizarCompra.FinalizoCompra();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        ProdMyStoreStep title = new ProdMyStoreStep(driver); // Asegúrate de que driver no sea null
        title.TituloCarrito();
        screenShot();
        /*ProdMyStoreStep title = new ProdMyStoreStep(driver);
        title.TituloCarrito();
        screenShot();*/
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        ProdMyStoreStep precioTot = new ProdMyStoreStep(driver);
        precioTot.ValidacionPrecioCarrito();

    }
}
