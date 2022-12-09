@test
  Feature: Registration
    Scenario: As a user I should be able to register successfully
      Given I am on registration Page
      When I enter requiired registration details
      And I click on registration button
      Then  I should be able to login successfully