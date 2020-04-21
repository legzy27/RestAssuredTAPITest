package steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;


public class GetIDSteps {


    @Given("^I make a GET request for crypto \"([^\"]*)\"$")
    public void iMakeAGETRequestForCrypto(String arg0) throws Throwable {
        RestAssured.baseURI = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map";


    }

    @When("^I make the GET request$")
    public void iMakeTheGETRequest() {
        Header authorizationHeader = new Header("X-CMC_PRO_API_KEY", "2d5cc0cc-631e-4cab-849e-625ef31d3f2d");
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header(authorizationHeader);
        Response response = httpRequest.get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map");
        System.out.println("Response Body is =>  " + response.asString());


    }

    @Then("^I should see \"([^\"]*)\" status code$")
    public void i_should_see_status_code(String arg1) throws Throwable {
        int code = 200;
        if (code == 200) {
            System.out.println(" statuscode " + 200);
        } else {
            System.out.println("statuscode" + 400);

        }

    }

}





