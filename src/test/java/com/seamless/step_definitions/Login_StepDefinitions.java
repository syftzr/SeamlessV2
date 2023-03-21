package com.seamless.step_definitions;

import com.seamless.pages.LoginPage;
import com.seamless.utilities.ConfigurationReader;
import com.seamless.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {

    LoginPage loginPage=new LoginPage();
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("browser"));
    }

    @When("user can write valid username")
    public void userCanWriteValidUsername() {
        loginPage.userName.sendKeys("Employee160");
    }

    @And("user can write valid password")
    public void userCanWriteValidPassword() {
        loginPage.inputPassword.sendKeys("Employee123");
    }

    @And("user can click login button")
    public void userCanClickLoginButton() {
        loginPage.loginButton.click();
    }

    @Then("user can see dashboard")
    public void userCanSeeDashboard() {
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains("dashboard"));
    }

    @And("user can press Enter key")
    public void userCanPressEnterKey() {
        loginPage.inputPassword.sendKeys(Keys.ENTER);
    }

    @When("user can write valid or invalid username {string}")
    public void userCanWriteValidOrInvalidUsername(String username) {
loginPage.userName.sendKeys(username);
    }

    @And("user can write valid or invalid password {string}")
    public void userCanWriteValidOrInvalidPassword(String password) {
    loginPage.inputPassword.sendKeys(password);
    }

    @Then("user can not see dashboard and {string} message should be displayed")
    public void userCanNotSeeDashboardAndMessageShouldBeDisplayed(String message) {
    Assert.assertEquals(loginPage.wrongMsg.getText(),"Wrong username or password.");
    }

    @When("user can leave username box empty")
    public void userCanLeaveUsernameBoxEmpty() {

    }

    @Then("user can not login and {string} message should be displayed")
    public void userCanNotLoginAndMessageShouldBeDisplayed(String message) {
        Assert.assertEquals(loginPage.fillOutMessage.getText(),"Please fill out this field");
    }

    @And("user can leave password box empty")
    public void userCanLeavePasswordBoxEmpty() {
    }

    @Then("user can see the password in a form of dots")
    public void userCanSeeThePasswordInAFormOfDots() {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("type"),"password");
    }

    @And("user clicks eye icon")
    public void userClicksEyeIcon() {
        loginPage.eyeIcon.click();
    }

    @Then("User can see the password explicitly")
    public void userCanSeeThePasswordExplicitly() {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("type"),"text");
    }

    @Then("User can see the {string} link")
    public void userCanSeeTheLink(String forgotPassword) {
        Assert.assertEquals(loginPage.forgotPassword.getText(),"Forgot password?");
    }

    @When("user clicks the {string} link")
    public void userClicksTheLink(String arg0) {
        loginPage.forgotPassword.click();
    }

    @Then("User can see the {string} button")
    public void userCanSeeTheButton(String resetPassword) {
        Assert.assertEquals(loginPage.resetPassword.getText(),"Reset Password");
    }

    @Then("User can see valid placeholder on username field")
    public void userCanSeeValidPlaceholderOnUsernameField() {
       Assert.assertEquals(loginPage.userName.getAttribute("placeholder"),"Username or email");
    }

    @Then("User can see valid placeholder on password field")
    public void userCanSeeValidPlaceholderOnPasswordField() {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("placeholder"),"Password");
    }
}
