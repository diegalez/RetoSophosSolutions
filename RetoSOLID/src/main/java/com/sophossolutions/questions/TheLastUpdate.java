package com.sophossolutions.questions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class TheLastUpdate implements Question<Boolean> {

  public static TheLastUpdate is(){
    return new TheLastUpdate();
  }

  @Subject("verify last update")
  @Override
  public Boolean answeredBy(Actor actor) {

    Long updatePost = theActorInTheSpotlight().recall("LAST_UPDATE_POST");
    Long updateGet = theActorInTheSpotlight().recall("LAST_UPDATE_GET");

    return updateGet.equals(updatePost);
  }
}
