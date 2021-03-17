package com.sophossolutions.tasks;

import com.sophossolutions.utils.Constants;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetMethod implements Task {

  public static GetMethod validateData() {
    return Tasks.instrumented(GetMethod.class);
  }

  @Step("{0} consume get method")
  @Override
  public <T extends Actor> void performAs(T actor) {

    String dataUpdated = actor.recall("UPDATE");

    actor.attemptsTo(
        Get.resource(Constants.RESOURCE_API + dataUpdated).with(
            request -> request.headers(HttpHeaders.CONTENT_TYPE, ContentType.JSON).log().all())
    );

    ResponseBody responseBody = SerenityRest.lastResponse().getBody();
    String body = responseBody.asString();

    int i = body.indexOf("{");
    body = body.substring(i);
    JSONObject json = new JSONObject(body.trim());

    actor.remember("LAST_UPDATE_GET", json.get("lastUpdate"));
  }
}