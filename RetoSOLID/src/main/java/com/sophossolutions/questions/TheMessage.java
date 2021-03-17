package com.sophossolutions.questions;

import static com.sophossolutions.userinterfaces.FinishElements.THANKS_MESSAGE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

public class TheMessage implements Question<String> {

  public static TheMessage ofPurchase() {
    return new TheMessage();
  }

  @Subject("validate the message of purchase")
  @Override
  public String answeredBy(Actor actor) {
    return Text.of(THANKS_MESSAGE).viewedBy(actor).asString();
  }
}