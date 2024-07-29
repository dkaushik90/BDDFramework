package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/reports.html", "json:target/cucumber-reports/cucumber.json"},
        features = "C://Users//dkaushik//eclipse-workspace//BDDFramework/Features",
        glue = "stepDefinations",
        tags = "@smoketest",
        dryRun = false,
        monochrome = true
)
public class TestRunner {
    // No-argument constructor is optional, can be omitted
}
