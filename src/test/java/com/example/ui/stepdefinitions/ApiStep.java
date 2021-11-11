package com.example.ui.stepdefinitions;

import com.example.ui.helper.BuildJsonFile;
import com.example.ui.helper.RestInteractionPoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class ApiStep {
    BuildJsonFile buildJsonFile =new BuildJsonFile();
    RestInteractionPoint restInteractionPoint=new RestInteractionPoint();
    Response response;


    @Given("I get a request {string}  {string}")
    public void iGetARequest(String endpoint, String name) throws Exception {
        response =restInteractionPoint.post(endpoint,buildJsonFile.Json(name));
        response.prettyPrint();
        System.setProperty("PetId",response.body().path("id").toString());
    }

    @Then("I add a new pet and status available {string}")
    public void iAddANewPetAndStatusAvailable(String expectedResults) {
        String result = response.getBody().path("name").toString();
        Assert.assertEquals(result,expectedResults);
    }

}
