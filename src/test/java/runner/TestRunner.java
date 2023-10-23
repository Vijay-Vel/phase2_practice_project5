package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\USER\\eclipse-workspace\\CucumberLessonEndProject1\\src\\test\\java\\features\\amazonPageDemo.feature",
   				 glue= {"steps"},
				dryRun=false,
				plugin={"pretty",
						"html:target/amazonreport.html"},
				tags="@all"

		)
public class TestRunner {

}
