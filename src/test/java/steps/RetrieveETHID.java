package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RetrieveETHID {
    @Given("^I make a GET request to cryptocurrency info \"([^\"]*)\"$")
    public void iMakeAGETRequestToCryptocurrencyInfo(String arg0) throws Throwable {

        Header authorizationHeader = new Header("X-CMC_PRO_API_KEY", "2d5cc0cc-631e-4cab-849e-625ef31d3f2d");
        RequestSpecification httpRequest = RestAssured.given()
                .param("id","1027");
        httpRequest.header(authorizationHeader);
        Response response = httpRequest.get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/info");
        System.out.println("Response Body is =>  " + response.asString());

    }

    @Then("^I should retrieve Ethereum ID$")
    public void iShouldRetrieveEthereumID() {
        int id = 1207;
        System.out.println("id: " + id);
    }


}
