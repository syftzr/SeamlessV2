package com.seamless.pages;

import com.seamless.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id="user")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/form/fieldset/p[3]")
    public WebElement wrongMsg;

    @FindBy(xpath = "//input[@id='user' and @required='required']")
    public WebElement fillOutMessage;

    @FindBy(css = "input[type='password']")
    public WebElement passwordAsDots;

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement eyeIcon;

    @FindBy(id="lost-password")
    public WebElement forgotPassword;

    @FindBy(id="reset-password-submit")
    public WebElement resetPassword;






    public void login(String username, String password) {
        userName.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }



}
