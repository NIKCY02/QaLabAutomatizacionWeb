package com.nttdata.page;
import org.openqa.selenium.By;

public class ProdMyStorePage {
    public static By IniciarSesion = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span");
    public static By MensajeInicio = By.xpath("//*[@id=\"content\"]/section/div/ul/li");
    public static By Usuario = By.xpath("//*[@id=\"field-email\"]");
    public static By Password = By.xpath("//*[@id=\"field-password\"]");
    public static By InicioSesionBtn = By.xpath("//*[@id=\"submit-login\"]");
    public static By IngresoCategoriaClothes = By.xpath("//*[@id=\"category-3\"]/a");
    public static By IngresoCategoriaAccesorios = By.xpath("//*[@id=\"category-6\"]/a");
    public static By IngresoCategoriaArt = By.xpath("//*[@id=\"category-9\"]/a");
    public static By IngresoSubcategoriaMen = By.xpath("//*[@id=\"category-4\"]/a");
    public static By IngresoSubcategoriaWomen = By.xpath("//*[@id=\"category-5\"]/a");
    public static By IngresoSubcategoriaStationery = By.xpath("//*[@id=\"category-7\"]/a");
    public static By IngresoSubcategoriaHome_Accessories = By.xpath("//*[@id=\"category-8\"]/a");
    public static By SeleccionoPrimerProducto = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");
    public static By Elijo2Unidades = By.xpath("//*[@id=\"quantity_wanted\"]");
    public static By AgregoalcarritodeCompra = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By PrecioProducto = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By CantidadProducto = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By CalcularCompra = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By FinalizarCompraBtn = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
    public static By TituloCarrito = By.xpath("//h1[contains(text(), 'Carrito')]");
    public static By CantProducto = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/input");
    public static By CantPrecio = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
    public static By CalculoPrecioTotal = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");


}
