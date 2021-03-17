package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class OverviewElements {

  public static final Target FINISH_BUTTON = Target.the("finish button")
      .locatedBy("//a[.= 'FINISH']");

  private OverviewElements() {

  }
}
