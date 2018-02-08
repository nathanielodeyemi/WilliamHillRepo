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
  "name": "user is on the Home Page",
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
  "duration": 5049393,
  "error_message": "java.lang.NullPointerException\r\n\tat java.util.Properties$LineReader.readLine(Properties.java:434)\r\n\tat java.util.Properties.load0(Properties.java:353)\r\n\tat java.util.Properties.load(Properties.java:341)\r\n\tat com.williamhill.base.TestBase.loadWebProperties(TestBase.java:39)\r\n\tat com.williamhill.base.TestBase.initialization(TestBase.java:53)\r\n\tat stepDefinition.PlaceBetTest_Steps.setUp(PlaceBetTest_Steps.java:40)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:202)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\r\n",
  "status": "failed"
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
  "name": "user is on the Home Page",
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
  "status": "skipped"
});
formatter.match({
  "location": "PlaceBetTest_Steps.successfully_login()"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "location": "PlaceBetTest_Steps.selects_the_first_active_match()"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "location": "PlaceBetTest_Steps.bet_should_be_placed_successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlaceBetTest_Steps.user_verifies_the_return_value_on_the_betting_receipt()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlaceBetTest_Steps.user_confirms_the_total_stake_on_the_betting_receipt()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlaceBetTest_Steps.user_account_balance_has_been_updated()"
});
formatter.result({
  "status": "skipped"
});
});