package pl.jsystems.qa.frontend.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "classpath:pl.jsystems.qa.frontend.cucumber.steps",
        plugin = {"html:target/cucumber-html-report", "rerun:target/rerun.txt"},
        tags = {
               "@window",
//                "@windowtest"
        }
)

public class RunTest {

}
