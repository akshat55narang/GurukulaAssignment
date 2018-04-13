package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources"
		,glue="stepDefinition"
		,plugin={"pretty" , "html:/home/akshat/Documents/report1.html"}
		//,tags={"@E2E"}
		//,dryRun=true
		
		)
public class TestRunner {

}
