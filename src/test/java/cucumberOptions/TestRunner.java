package cucumberOptions;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        //plugin = "json: target/jsonReports/cucumber-report.json",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html"
        }     ,
        glue = "stepDefinitions"
)
public class TestRunner {
}
