package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartElements {

  public static final Target PRODUCT_IN_THE_CART = Target.the("product in the cart")
      .locatedBy("//div[@class = 'cart_item_label']//a//div");
  public static final Target CHECKOUT = Target.the("checkout")
      .locatedBy("//a[. = 'CHECKOUT']");

  private CartElements() {
  }
}
