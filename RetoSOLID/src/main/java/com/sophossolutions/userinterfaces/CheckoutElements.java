package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutElements {

  public static final Target FIRST_NAME_FIELD = Target.the("first name field")
      .locatedBy("//input[@id= 'first-name']");
  public static final Target LAST_NAME_FIELD = Target.the("last name field")
      .locatedBy("//input[@id= 'last-name']");
  public static final Target POSTAL_CODE_FIELD = Target.the("postal code field")
      .locatedBy("//input[@id= 'postal-code']");
  public static final Target CONTINUE_BUTTON = Target.the("continue button")
      .locatedBy("//input[@value= 'CONTINUE']");

  private CheckoutElements() {
  }
}
