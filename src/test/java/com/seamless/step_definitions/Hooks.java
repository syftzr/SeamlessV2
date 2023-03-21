package com.seamless.step_definitions;

import com.seamless.utilities.BrowserUtils;
import com.seamless.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            BrowserUtils.sleep(2);
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            BrowserUtils.sleep(2);
        }
    }
    @After
    public void closeBrowser() {
       Driver.quitDriver();
    }
}
