package bdd;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/java/features/login.feature",
		glue="bdd")

public class cucumberrunner extends AbstractTestNGCucumberTests {

}
