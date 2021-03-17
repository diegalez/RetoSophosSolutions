package com.sophossolutions.tasks;

import static com.sophossolutions.userinterfaces.LoginElements.LOGIN_BUTTON;
import static com.sophossolutions.userinterfaces.LoginElements.PASSWORD_FIELD;
import static com.sophossolutions.userinterfaces.LoginElements.USERNAME_FIELD;
import static com.sophossolutions.userinterfaces.ProductElements.CART;
import static com.sophossolutions.utils.Constants.PAGE_URL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.sophossolutions.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class Login implements Task {

  private final User user;

  public Login(User user) {
    this.user = user;
  }

  public static Login withCredentials(User user) {
    return Tasks.instrumented(Login.class, user);
  }

  @Step("{0} login with credentials")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.wasAbleTo(
        Open.url(PAGE_URL),
        WaitUntil.the(USERNAME_FIELD, isVisible()),
        Enter.theValue(user.getUser()).into(USERNAME_FIELD),
        Enter.theValue(user.getPassword()).into(PASSWORD_FIELD),
        Click.on(LOGIN_BUTTON),
        WaitUntil.the(CART, isVisible())
    );
  }
}