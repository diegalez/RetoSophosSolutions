#language: es

Característica: Actualizar registro en la API
  Yo, como usuario
  Necesito consumir el recurso de la API
  Para actualizar un registro

  @ConsumeAPI
  Escenario:  Consume API
    Dado que el usuario se conecta a la  API
    Cuando  consume el metodo post para actualizar el dato
    Entonces deberia ver el codigo de respuesta 200
    Cuando consume el metodo get
    Entonces verifica que la actualizacion se realiza correctamente
