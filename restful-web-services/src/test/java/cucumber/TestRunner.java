package cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.example",
        plugin = {"pretty", "html:target/cucumber/cucumber.html", "json:target/cucumber/cucumber.json"})
public class TestRunner {
}
