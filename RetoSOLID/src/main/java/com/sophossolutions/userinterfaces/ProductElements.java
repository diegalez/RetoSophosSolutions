package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductElements {

  public static final Target CART = Target.the("cart on page")
      .locatedBy("//div[@id = 'shopping_cart_container']");
  public static final Target ADD_TO_CART = Target.the("add product {0} add to cart")
      .locatedBy("//div[contains(text(), '{0}')]//following::div[2]/button");

  private ProductElements() {
  }
}