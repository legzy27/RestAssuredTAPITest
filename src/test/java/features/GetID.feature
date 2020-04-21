Feature: Retrieve ID from bitcoin (BTC), and other cryptocurrencies from coinmarket endpoints


   Scenario: Retrieving ID
     Given I make a GET request for crypto "/get"
     When I make the GET request
     Then I should see "200" status code

    Scenario: convert ID to Bolivian Boliviano
      Given I make a GET request to price conversion "/get"
      Then I should see IDs convert to Bolivian Boliviano

    Scenario: Retrieve the Ethereum (ID 1027) technical documentation website
        Given I make a GET request to cryptocurrency info "/get"
        Then I should retrieve Ethereum ID

   Scenario: Retrieve the first 10 currencies from the cryptocurrency/info call ID
    Given I make a GET request to cryptocurrency info page "/get"
    Then I should see all IDs return with info