#Author: your.email@your.domain.com

@tag
Feature: Place a bet
  I want place a bet on the first active any sport match

  @tag1
  Scenario Outline: Successful place a bet
    Given user is on the Home Page and login
    And successfully logs in
    When user navigate to the <sport> Page
    And selects the first active match
    And place a bet <stake> and click Place a bet button
    Then bet should be placed successfully
    And user verifies the return value on the betting receipt
    And user confirms the total stake on the betting receipt 
    And user account balance has been updated

	  Examples:
	  	| sport  	 	 | stake 	| 
      | "Football" | "0.05" | 

