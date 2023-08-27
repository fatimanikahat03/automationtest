package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/resources/featuresfile"},
        glue = {"stepdefinition"},
        plugin = {"pretty","html:target/cucumber.html",
                "json:target/json1.json",
                "junit:target/junit1.xml"}


)


public class runner {
}
