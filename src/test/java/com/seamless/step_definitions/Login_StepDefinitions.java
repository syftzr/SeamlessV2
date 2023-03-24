package com.seamless.step_definitions;

import com.seamless.pages.LoginPage;
import com.seamless.utilities.ConfigurationReader;
import com.seamless.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();


    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginUrl"));
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
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }

    @And("user can press Enter key")
    public void userCanPressEnterKey() {
        loginPage.inputPassword.sendKeys(Keys.ENTER);
    }

    @Then("user can see the dashboard")
    public void userCanSeeTheDashboard() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
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
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 40);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='warning wrongPasswordMsg']")));
        Assert.assertEquals(message,loginPage.wrongMsg.getText());

    }

    @Then("user can not login and {string} should be displayed")
    public void userCanNotLoginAndShouldBeDisplayed(String message) {
               Assert.assertTrue((loginPage.fillOutMessage.isDisplayed() || loginPage.wrongMsg.getText().toLowerCase().equals("Please fill out this field")));
    }

    @Then("user can see the password in a form of dots")
    public void userCanSeeThePasswordInAFormOfDots() {

        Assert.assertEquals("password", loginPage.inputPassword.getAttribute("type"));
    }

    @And("user clicks eye icon")
    public void userClicksEyeIcon() {
        loginPage.eyeIcon.click();
    }

    @Then("User can see the password explicitly")
    public void userCanSeeThePasswordExplicitly() {
        Assert.assertEquals("text", loginPage.inputPassword.getAttribute("type"));
    }

    @Then("User can see the {string} link")
    public void userCanSeeTheLink(String forgotLink) {
        Assert.assertTrue(loginPage.forgotPassword.isDisplayed());
    }

    @When("user clicks the {string} link")
    public void userClicksTheLink(String forgotLink) {
        loginPage.forgotPassword.click();
    }

    @Then("User can see the {string} button")
    public void userCanSeeTheButton(String resetPasword) {
    Assert.assertTrue(loginPage.resetPassword.isDisplayed());
    }

    @Then("User can see valid placeholder on username field")
    public void userCanSeeValidPlaceholderOnUsernameField() {
    Assert.assertEquals("Username or email",loginPage.userName.getAttribute("placeholder"));
    }

    @Then("User can see valid placeholder on password field")
    public void userCanSeeValidPlaceholderOnPasswordField() {
        Assert.assertEquals("Password",loginPage.inputPassword.getAttribute("placeholder"));

    }
}
