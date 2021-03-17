package com.sophossolutions.utils;

public enum ErrorMessage {

  MESSAGE_PURCHASE("El mensaje esperado no coincide"),
  ERROR_MESSAGE_SERVICE("Error al consumir el servicio"),
  ERROR_CODE("El servicio no responde 200");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}