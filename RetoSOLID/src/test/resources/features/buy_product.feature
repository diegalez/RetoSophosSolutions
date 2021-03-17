#language: es

Característica: Agregar un producto al carrito de compras
  Yo, como usuario de la plataforma
  Quiero agregar un producto al carrito
  Para su futura compra

  @MakePurchase
  Esquema del escenario: Agregar producto al carrito
    Dado  que el usuario inicia sesion en la plataforma
      | user   | password   |
      | <user> | <password> |
    Cuando el agrega el producto <product> al carrito
    Entonces deberia ver el mensaje <messageExpected> de agradecimiento

    Ejemplos:
      | user          | password     | product           | messageExpected          |
      | standard_user | secret_sauce | Sauce Labs Onesie | THANK YOU FOR YOUR ORDER |