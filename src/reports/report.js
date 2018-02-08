$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FootballBet_Test.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    }
  ],
  "line": 4,
  "name": "Place a bet",
  "description": "I want place a bet on the first active any sport match",
  "id": "place-a-bet",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Successful place a bet",
  "description": "",
  "id": "place-a-bet;successful-place-a-bet",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "user is on the Home Page and login",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "successfully logs in",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "user navigate to the \u003csport\u003e Page",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "selects the first active match",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "place a bet \u003cstake\u003e and click Place a bet button",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "bet should be placed successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "user verifies the return value on the betting receipt",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "user confirms the total stake on the betting receipt",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "user account balance has been updated",
  "keyword": "And "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "place-a-bet;successful-place-a-bet;",
  "rows": [
    {
      "cells": [
        "sport",
        "stake"
      ],
      "line": 20,
      "id": "place-a-bet;successful-place-a-bet;;1"
    },
    {
      "cells": [
        "\"Football\"",
        "\"0.05\""
      ],
      "line": 21,
      "id": "place-a-bet;successful-place-a-bet;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9694014999,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Successful place a bet",
  "description": "",
  "id": "place-a-bet;successful-place-a-bet;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@tag"
    },
    {
      "line": 7,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "user is on the Home Page and login",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "successfully logs in",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "user navigate to the \"Football\" Page",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "selects the first active match",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "place a bet \"0.05\" and click Place a bet button",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "bet should be placed successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "user verifies the return value on the betting receipt",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "user confirms the total stake on the betting receipt",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "user account balance has been updated",
  "keyword": "And "
});
formatter.match({
  "location": "PlaceBetTest_Steps.user_is_on_the_Home_Page()"
});
formatter.result({
  "duration": 1183043811,
  "status": "passed"
});
formatter.match({
  "location": "PlaceBetTest_Steps.successfully_login()"
});
formatter.result({
  "duration": 4711254600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Football",
      "offset": 22
    }
  ],
  "location": "PlaceBetTest_Steps.user_navigate_to_the_sport_Page(String)"
});
formatter.result({
  "duration": 810976436,
  "status": "passed"
});
formatter.match({
  "location": "PlaceBetTest_Steps.selects_the_first_active_match()"
});
formatter.result({
  "duration": 2102803276,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.05",
      "offset": 13
    }
  ],
  "location": "PlaceBetTest_Steps.place_a_bet_and_click_Place_a_bet_button(String)"
});
formatter.result({
  "duration": 2646206423,
  "status": "passed"
});
formatter.match({
  "location": "PlaceBetTest_Steps.bet_should_be_placed_successfully()"
});
formatter.result({
  "duration": 5044475288,
  "status": "passed"
});
formatter.match({
  "location": "PlaceBetTest_Steps.user_verifies_the_return_value_on_the_betting_receipt()"
});
formatter.result({
  "duration": 119463669,
  "status": "passed"
});
formatter.match({
  "location": "PlaceBetTest_Steps.user_confirms_the_total_stake_on_the_betting_receipt()"
});
formatter.result({
  "duration": 32238260,
  "status": "passed"
});
formatter.match({
  "location": "PlaceBetTest_Steps.user_account_balance_has_been_updated()"
});
formatter.result({
  "duration": 20825113,
  "status": "passed"
});
formatter.after({
  "duration": 684372330,
  "status": "passed"
});
});