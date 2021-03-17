package com.sophossolutions.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.sophossolutions.exceptions.ExceptionError;
import com.sophossolutions.models.User;
import com.sophossolutions.questions.TheMessage;
import com.sophossolutions.tasks.BuyProduct;
import com.sophossolutions.tasks.Login;
import com.sophossolutions.utils.ErrorMessage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.util.List;

public class BuyProductStepDefinitions {

  @Dado("^que el usuario inicia sesion en la plataforma$")
  public void queElUsuarioIniciaSesionEnLaPlataforma(List<User> users) {
    theActorCalled("actor").wasAbleTo(Login.withCredentials(users.get(0)));
  }

  @Cuando("^el agrega el producto (.*) al carrito$")
  public void elAgregaElProductoAlCarrito(String product) {
    theActorInTheSpotlight().attemptsTo(BuyProduct.selected(product));
  }

  @Entonces("^deberia ver el mensaje (.*) de agradecimiento$")
  public void deberiaVerElMensajeDeAgradecimiento(String messageExpected) {
    theActorInTheSpotlight().should(seeThat(TheMessage.ofPurchase(), equalTo(messageExpected))
       .orComplainWith(ExceptionError.class, ErrorMessage.MESSAGE_PURCHASE.getMessage()));
  }
}