package com.sophossolutions.tasks;

import static com.sophossolutions.userinterfaces.CartElements.CHECKOUT;
import static com.sophossolutions.userinterfaces.CartElements.PRODUCT_IN_THE_CART;
import static com.sophossolutions.userinterfaces.OverviewElements.FINISH_BUTTON;
import static com.sophossolutions.userinterfaces.ProductElements.ADD_TO_CART;
import static com.sophossolutions.userinterfaces.ProductElements.CART;

import com.sophossolutions.interactions.Checkout;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

public class BuyProduct implements Task {

  private String product;

  public BuyProduct(String product) {
    this.product = product;
  }

  public static BuyProduct selected(String product) {
    return Tasks.instrumented(BuyProduct.class, product);
  }

  @Step("{0} buy product and pay")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Click.on(ADD_TO_CART.of(product)),
        Click.on(CART)
    );

    actor.attemptsTo(
        Ensure.that(PRODUCT_IN_THE_CART.resolveFor(actor).getText()).isEqualTo(product),
        Click.on(CHECKOUT),
        Checkout.product(),
        Click.on(FINISH_BUTTON)
    );
  }
}