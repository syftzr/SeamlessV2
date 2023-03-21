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

public class StepDefinitions {

LoginPage loginPage=new LoginPage();

@Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginUrl"));
    }
    @When("user can write valid username")
    public void user_can_write_valid_username() {
        loginPage.userName.sendKeys("Employee160");
    }
    @When("user can write valid password")
    public void user_can_write_valid_password() {
        loginPage.inputPassword.sendKeys("Employee123");
    }
    @When("user can click login button")
    public void user_can_click_login_button() {
        loginPage.loginButton.click();
    }
    @Then("user can see dashboard")
    public void user_can_see_dashboard() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().toLowerCase().contains("dashboard"));
    }

    @And("user can press Enter key")
    public void userCanPressEnterKey() {
    loginPage.inputPassword.sendKeys(Keys.ENTER);
    }

    public void login(String username, String password) {
        loginPage.userName.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        loginPage.loginButton.click();
    }

    @When("user can write valid\\/invalid username {string}")
    public void userCanWriteValidInvalidUsername(String username) {
    loginPage.userName.sendKeys(username);
    }

    @And("user can write valid\\/invalid password {string}")
    public void userCanWriteValidInvalidPassword(String password) {
    loginPage.inputPassword.sendKeys(password);
}


    @Then("user can not see dashboard and {string} massage should be displayed")
    public void userCanNotSeeDashboardAndMassageShouldBeDisplayed(String arg0) {
    Assert.assertEquals("Wrong username or password.",loginPage.wrongMsg.getText());
    }


}
