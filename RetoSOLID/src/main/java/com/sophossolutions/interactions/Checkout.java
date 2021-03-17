package com.sophossolutions.interactions;

import static com.sophossolutions.userinterfaces.CheckoutElements.CONTINUE_BUTTON;
import static com.sophossolutions.userinterfaces.CheckoutElements.FIRST_NAME_FIELD;
import static com.sophossolutions.userinterfaces.CheckoutElements.LAST_NAME_FIELD;
import static com.sophossolutions.userinterfaces.CheckoutElements.POSTAL_CODE_FIELD;
import static com.sophossolutions.utils.Constants.FIRST_NAME;
import static com.sophossolutions.utils.Constants.LAST_NAME;
import static com.sophossolutions.utils.Constants.POSTAL_CODE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class Checkout implements Interaction {

  public static Checkout product() {
    return Tasks.instrumented(Checkout.class);
  }

  @Step("checkout product")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Enter.theValue(FIRST_NAME).into(FIRST_NAME_FIELD),
        Enter.theValue(LAST_NAME).into(LAST_NAME_FIELD),
        Enter.theValue(POSTAL_CODE).into(POSTAL_CODE_FIELD),
        Click.on(CONTINUE_BUTTON)
    );
  }
}
