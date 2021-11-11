package com.example.ui.stepdefinitions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.example.ui.helper.BaseWeb;
//import com.example.ui.pages.HomePage;
import com.example.ui.pages.flow.flowExample;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonSteps {
   // private HomePage homePage;
    public static WebDriver driver = BaseWeb.getDriver();
    private flowExample flowExample;


    public CommonSteps() {
        //homePage = HomePage.getInstance(driver);
        flowExample = new flowExample();
    }
//    @Given("^I am on home page$")
//    public void i_am_on_home_page() throws Throwable {
//        //homePage.verifyHomePage();
//    }
//
//    @When("^Click on login button$")
//    public void click_on_login_button() throws Throwable {
//        //homePage.clickOnLoginButton();
//
//    }
//
//    @When("^I enter login details$")
//    public void i_enter_login_details() throws Throwable {
//
//    }
//
//    @Then("^login form gets open$")
//    public void login_form_gets_open() throws Throwable {
//
//    }
//
//    @Then("^I am successfully logged in$")
//    public void i_am_successfully_logged_in() throws Throwable {
//        Assert.fail("1000");
//    }

    @Given("I navigate to login page")
    public void iNavigateToLoginPage() throws Exception{
        ExtentCucumberAdapter.addTestStepLog("Successfully Launch the page");
    }

    @When("I enter username and password {string} {string}")
    public void iEnterUsernameAndPassword(String username, String password)throws Exception {
        flowExample.EnterCredentials(username, password);
    }

    @And("I click login button")
    public void iClickLoginButton()throws Exception {
        flowExample.ClickLogin();
    }

    @And("I click add to cart")
    public void iClickAddToCart()throws Exception {
        flowExample.AddToCart();
    }

    @And("I view Cart")
    public void iViewCart()throws Exception {
        flowExample.Viewcart();
    }

    @And("I click checkout")
    public void iClickCheckout()throws Exception {
        flowExample.CheckOut();
    }

    @And("I enter customer details {string} {string} {string}")
    public void iEnterCustomerDetails(String firstname, String lastname, String postcode) throws Exception{
        flowExample.EnterCustomerDetails(firstname,lastname,postcode);
    }

    @And("I click continue")
    public void iClickContinue()throws Exception {
        flowExample.ClickContinue();
    }

    @And("I click finish button")
    public void iClickFinishButton()throws Exception {
        flowExample.ClickFinish();
    }

    @And("I assert the results {string}")
    public void iAssertTheResults(String value)throws Exception {
        flowExample.Asserting(value);
    }

    @Then("I logout Application")
    public void iLogoutApplication()throws Exception {
        flowExample.logout();
    }
}