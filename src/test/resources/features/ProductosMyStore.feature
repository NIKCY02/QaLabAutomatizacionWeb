#language: es
@testfeature
Característica: Product - Store

  @ValidacionPrecio
  Esquema del escenario: Validación del precio de un producto

  Dado estoy en la página de la tienda
  Y me logueo con mi usuario "<usuario>" y clave "<clave>"
  Cuando navego a la categoria "<categoria>" y luego a la subcategoria "<subcategoria>"
  Y agrego <cantidad> unidades del primer producto al carrito
  Entonces valido en el popup la confirmación del producto agregado
  Y valido en el popup que el monto total sea calculado correctamente
  Cuando finalizo la compra
  Entonces valido el titulo de la pagina del carrito
  Y vuelvo a validar el calculo de precios en el carrito

    Ejemplos:
  | usuario                      | clave       | categoria | subcategoria | cantidad |
  | nikcoluribehuamani@gmail.com | Nikcol1234  | CLOTHES   | MEN          | 2        |
  | alvaroavalos@gmail.com       | Alvaro1234  | CLOTHES   | WOMEN        | 1        |
