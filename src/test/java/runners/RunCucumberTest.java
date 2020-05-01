package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue = "stepDefinitions",
		plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"},
		tags = {}
		)
public class RunCucumberTest {
	
}