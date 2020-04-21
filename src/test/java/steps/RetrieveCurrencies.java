package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RetrieveCurrencies {
    @Given("^I make a GET request to cryptocurrency info page \"([^\"]*)\"$")
    public void iMakeAGETRequestToCryptocurrencyInfoPage(String arg0) throws Throwable {
        Header authorizationHeader = new Header("X-CMC_PRO_API_KEY", "2d5cc0cc-631e-4cab-849e-625ef31d3f2d");
        RequestSpecification httpRequest = RestAssured.given()
                .param("id","1027,1970,1974,1975,1976,1982,1983,1984,1985,1988");
        httpRequest.header(authorizationHeader);
        Response response = httpRequest.get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/info");
        System.out.println("Response Body is =>  " + response.asString());

    }
    @Then("^I should see all IDs return with info$")
    public void iShouldSeeAllIDsReturnWithInfo() {
        int [] num =  {1027,1970,1974,1975,1976,1982,1983,1984,1985,1988};
        System.out.println("ID " + Arrays.toString(num));
    }
}
