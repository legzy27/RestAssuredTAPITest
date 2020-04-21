package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ConversionID {
    @Given("^I make a GET request to price conversion \"([^\"]*)\"$")
    public void iMakeAGETRequestToPriceConversion(String arg0) throws Throwable {
        Header authorizationHeader = new Header("X-CMC_PRO_API_KEY", "2d5cc0cc-631e-4cab-849e-625ef31d3f2d");
        RequestSpecification httpRequest = RestAssured.given()
                  .param("id","1056")
                .param("amount", "50")
                .param("convert","BOB");
        httpRequest.header(authorizationHeader);
        Response response = httpRequest.get("https://pro-api.coinmarketcap.com/v1/tools/price-conversion");
        System.out.println("Response Body is =>  " + response.asString());
    }

    @Then("^I should see IDs convert to Bolivian Boliviano$")
    public void iShouldSeeIDsConvertToBolivianBoliviano() {

    }
}
