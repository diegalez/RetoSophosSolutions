package com.sophossolutions.tasks;

import com.sophossolutions.utils.Constants;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

public class PostMethod implements Task {

  private String data;

  public PostMethod(String data) {
    this.data = data;
  }

  public static PostMethod updateData(String update) {
    return Tasks.instrumented(PostMethod.class, update);
  }

  @Step("{0} consume post method")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Post.to(Constants.RESOURCE_API + "create/" + data)
        .with(request -> request.log().all())
    );

    actor.remember("UPDATE", data);

    ResponseBody responseBody = SerenityRest.lastResponse().getBody();
    Long lastUpdate = new JSONObject(responseBody.asString()).getLong("lastUpdate");

    actor.attemptsTo(
        Ensure.that(lastUpdate).isNotNull()
    );

    actor.remember("LAST_UPDATE_POST", lastUpdate);
  }
}