package com.sophossolutions.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import com.sophossolutions.exceptions.ExceptionError;
import com.sophossolutions.questions.LastResponseStatusCode;
import com.sophossolutions.questions.TheLastUpdate;
import com.sophossolutions.tasks.GetMethod;
import com.sophossolutions.tasks.PostMethod;
import com.sophossolutions.utils.Constants;
import com.sophossolutions.utils.ErrorMessage;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.commons.lang3.RandomStringUtils;

public class CallServiceStepDefinitions {

  @Before
  public void prepareStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("^que el usuario se conecta a la  API$")
  public void queElUsuarioSeConectaALaAPI() {
    theActorCalled("actor").whoCan(CallAnApi.at(Constants.API));
  }

  @Cuando("^consume el metodo post para actualizar el dato$")
  public void consumeElMetodoPostParaActualizarElDato() {
    theActorInTheSpotlight().attemptsTo(
        PostMethod.updateData(RandomStringUtils.random(5))
    );
  }

  @Entonces("^deberia ver el codigo de respuesta (\\d+)$")
  public void deberiaVerElCodigoDeRespuesta(int code) {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(code))
        .orComplainWith(ExceptionError.class, ErrorMessage.ERROR_CODE.getMessage()));
  }

  @Cuando("^consume el metodo get$")
  public void consumeElMetodoGet() {
    theActorInTheSpotlight().attemptsTo(GetMethod.validateData());
  }

  @Entonces("^verifica que la actualizacion se realiza correctamente$")
  public void verificaQueLaActualizacionSeRealizaCorrectamente() {

    theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheLastUpdate.is())
        .orComplainWith(ExceptionError.class, ErrorMessage.ERROR_MESSAGE_SERVICE.getMessage()));
  }
}