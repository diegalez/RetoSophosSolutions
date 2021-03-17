package com.sophossolutions.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class LastResponseStatusCode {

  private LastResponseStatusCode() {
  }

  @Subject("verify last response status code")
  public static Question<Boolean> is(int code) {
    return a -> SerenityRest.lastResponse().statusCode() == code;
  }
}
