package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources"
		,glue="stepDefinition"
		,tags={"@Register,@R1Login,@Login,@Logout"}
		//,dryRun=true
		
		)
public class TestRunner {

}
