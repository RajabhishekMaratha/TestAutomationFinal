package cucumber.testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/Features",
		dryRun = false,
		glue = "cucumber",
		monochrome=true,
		plugin= {"html:cucumberreport/index.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish=false
		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
