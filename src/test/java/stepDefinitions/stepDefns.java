package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AddPlace;
import pojo.Location;
import pojo.Update;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepDefns {

    RequestSpecification responseDeneme;
    Response resspec;
    Response response;
   // TestDataBuild data =new TestDataBuild();
    static String place_id;
    AddPlace p =new AddPlace();
    Update up = new Update();
    JsonPath js2;
    String responseStrng;
    static String name;

    @Given("Add Place Payload")
    public void add_place_payload() {
            // TODO Auto-generated method stub
            RestAssured.baseURI="https://rahulshettyacademy.com";

            p.setAccuracy(50);
            p.setAddress("29, side layout, cohen 09");
            p.setLanguage("French-IN");
            p.setPhone_number("(+91) 983 893 3937");
            p.setWebsite("https://rahulshettyacademy.com");

            name = "Frontline";
            p.setName(name);
            List<String> myList =new ArrayList<String>();
            myList.add("shoe park");
            myList.add("shop");

            p.setTypes(myList);
            Location l =new Location();
            l.setLat(-38.383494);
            l.setLng(33.427362);

            p.setLocation(l);

        responseDeneme= given().log().all().queryParam("key", "qaclick123")
                .contentType(ContentType.JSON);

        /*RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                    .setContentType(ContentType.JSON).build();

     resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

     res=given().log().all().spec(req).body(p).log().all();*/
    }
    @When("User calls {string} with post http request")
    public void user_calls_with_post_http_request(String string) {

        resspec = responseDeneme.body(p).when().post("/maps/api/place/add/json")
                .then().log().all().extract().response();

        responseStrng = resspec.asString();
        js2 = new JsonPath(responseStrng);
        place_id = js2.get("place_id");
        System.out.println("placeId = " + place_id);

    }
    @Then("API call got success with status code {int}")
    public void api_call_got_success_with_status_code(Integer int1) {
        int expStatus = int1;
        int actStatus = resspec.getStatusCode();
    assertEquals(expStatus,actStatus);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
    String actValue = js2.get(keyValue);
    assertEquals(actValue,expectedValue);
    }

    @Then("Place details are checked")
    public void place_details_are_checked() {
        resspec =responseDeneme.queryParam("place_id", place_id)
                .when().post("/maps/api/place/get/json").then().log().all().extract().response();
        responseStrng = resspec.asString();
        js2 = new JsonPath(responseStrng);
        String nameAct = js2.get("name");
        String nameExp = p.getName();

        assertEquals(nameAct,nameExp);

    }
    @Then("Place is updated")
    public void place_is_updated() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("\"palce is updated\" = " + "palce is updated");

        up.setAddress("70 Summer walk, USA");
        up.setPlace_id(place_id);
        up.setKey("qaclick123");
        resspec = responseDeneme.body(up).queryParam("key","qaclick123")
                .when().put("/maps/api/place/update/json").then().log().all().extract().response();
        responseStrng = resspec.asString();
        js2 = new JsonPath(responseStrng);
        String msgAct = js2.get("msg");
        String msgExp = "Address successfully updated";
        assertEquals(msgAct,msgExp);

    }
}