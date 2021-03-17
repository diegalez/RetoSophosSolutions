package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FinishElements {

  public static final Target THANKS_MESSAGE = Target.the("thanks message")
      .locatedBy("//h2[@class = 'complete-header']");

  private FinishElements() {
  }
}
