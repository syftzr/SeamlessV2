package com.seamless.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"rerun:target/rerun.txt",
                "html:target/cucumberReport.html",
                "json:target/cucumber.json"
        },

    features = "src/test/resources/features",
        glue = "com/seamless/step_definitions",
        tags = "",
        dryRun = false



            )


public class CukesRunner {
}
