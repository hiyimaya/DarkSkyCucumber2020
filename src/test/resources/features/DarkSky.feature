@web

Feature: Verify darksky

  Background:
    Given I am on DarkSkyPage

  @timelineformat
  Scenario: Verify timeline is displayed in correct format
   // When I entered California in search box
    When I entered South Lafayette Avenue, Chicago, IL in search box
    Then I verify timeline is displayed with two hours incremented

  @temptimeline

  Scenario:Verify individual day temp timeline
    When I expand today's timeline
    Then I verify lowest and highest temp is displayed correctly