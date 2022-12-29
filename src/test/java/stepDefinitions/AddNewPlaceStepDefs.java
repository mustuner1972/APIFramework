package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;


public class AddNewPlaceStepDefs {

    @Given("Add new place")
    public void add_new_place() {

        RestAssured.baseURI="https://rahulshettyacademy.com";

        String bodyy = "{\"location\": \n" +
                "{\n" +
                "\t\"lat\": -38.383494,\n" +
                "\t\"lng\": 33.427362\n" +
                "\t },\n" +
                "\t \"accuracy\": 50,\n" +
                "\t \"name\": \"Rahul Shetty Academy\",\n" +
                "\t \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "\t \"address\": \"29, side layout, cohen 09\",\n" +
                "\t \"types\": \n" +
                "\t [\n" +
                "\t \t\"shoe park\",\n" +
                "\t \t\"shop\"\n" +
                "\t ],\n" +
                "\t\t\t\t\"website\": \"http://rahulshettyacademy.com\", \n" +
                "\t\t\t\t\"language\": \"French-IN\"\n" +
                "\t\t\t}";
      //  String response = (Response) given().queryParam("key", "qaclick123").log().all()
        //        .then().header("Content-Type","application/json").body()
          //      .when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
                ;
    }
    @Then("Verify {string} is {string}")
    public void verify_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("API call status code is {string}")
    public void api_call_status_code_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
        //comment is written
    }

}
