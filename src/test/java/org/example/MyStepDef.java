package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDef {

    HomePage homePage=new HomePage();
    RegistrationPage registrationPage=new RegistrationPage();

    @Given("I am on registration Page")
    public void i_am_on_registration_page() {
        homePage.useClickOnRegistrationButton();
    }
    @When("I enter requiired registration details")
    public void i_enter_requiired_registration_details() {
        registrationPage.verifyUserIsOnRegistrationPage();
        registrationPage.userFillRegistrationForm();
    }
    @When("I click on registration button")
    public void i_click_on_registration_button() {
      registrationPage.userclickOnRegisterButton();
    }
    @Then("I should be able to login successfully")
    public void i_should_be_able_to_login_successfully() {

    }
}
