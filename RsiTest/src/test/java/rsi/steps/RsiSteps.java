package rsi.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import groovy.json.internal.LazyMap;
import rsi.support.RESTSupport;

import org.junit.Assert;

/**
 * Created by Lucas on 16/04/2019.
 */
public class RsiSteps {

    @Then("^user should see \"([^\"]*)\" message$")
    public void userShouldSeeMessage(String type) throws Throwable {
        LazyMap messageJson = new LazyMap();
        messageJson.put("save with success", 201);
        messageJson.put("success", 200);
        messageJson.put("no content", 204);
        messageJson.put("not found", 404);
        messageJson.put("unauthorized", 401);

        Assert.assertEquals(messageJson.get(type), RESTSupport.getResponseCode());

    }

    @And("^user wants to get response$")
    public void userWantsToSeeUserInformation() throws Throwable {
        RESTSupport.executeGet("https://jsonplaceholder.typicode.com/todos/1");
    }

    @Then("^user should see (.*) with value \"([^\"]*)\"$")
    public void userShouldSeeLoginWithValue(String title, String value) throws Throwable {
        Assert.assertEquals(value, RESTSupport.key("title"));
    }

}
