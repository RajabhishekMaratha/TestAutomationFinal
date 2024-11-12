package cucumber.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utility.ScreenShot;
import cucumber.PageObjectCucumber.PageObject;
import cucumber.hooks.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarLoanCalcSteps extends DriverInstance{
    WebDriver driver;
	PageObject poc = new PageObject(DriverInstance.getDriver());
	
	@Given("user click car loan")
	public void userClickCarLoan() {
	   DriverInstance.getLogger().info("Tapping CarLoan option");
	   poc.clickCarLoan();
	   ScreenShot.takeScreenshot(DriverInstance.getDriver(), "carLoan_option");
	}
	
	
	@Given("^send car loan amount value as (.+)$")
	public void sendCarLoanAmountValueAs(Integer loanAmount) {
		DriverInstance.getLogger().info("Entering car loan value");
	    poc.loanAmount(loanAmount);
		ScreenShot.takeScreenshot(DriverInstance.getDriver(),"carLoanValue");
	}
	
	@Given("^send interest rate as (.+)$")
	public void sendInterestRateAs(Double interestRate) {
		DriverInstance.getLogger().info("Entering Interest");
	    poc.interestRate(interestRate);
		ScreenShot.takeScreenshot(DriverInstance.getDriver(), "interest_value");
	}
	
	@Given("^send loan tensure as (.+)$")
	public void sendLoanTenureAs(Integer loanTenure) throws Exception {
	   DriverInstance.getLogger().info("Entering Tenure");
	   poc.loanTenure(loanTenure);
	   ScreenShot.takeScreenshot(DriverInstance.getDriver(), "loan_tenure");
	}
	
	@When("press enter")
	public void userClickOnYr() throws InterruptedException {
	    poc.pressEnter();
	}
	
	@Then("Display the interest amount and principle amount of first month")
	public void displayTheInterestAmountAndPrincipleAmountOfFirstMonth() throws Exception {
		DriverInstance.getLogger().info("Capturing interest and principle amount for first month");
		Thread.sleep(1000);
	    String[] amounts = poc.getAmounts();
	    int interestAmount=Integer.parseInt(amounts[0].replaceAll("[^0-9]", ""));
	    int principleAmount=Integer.parseInt(amounts[1].replaceAll("[^0-9]", ""));
	    
	    System.out.println("Interest Amount Of First Month: Rs."+interestAmount+"\nPrinciple Amount Of First Month: Rs."+principleAmount);
	    
	    Assert.assertTrue(interestAmount>0&&principleAmount>0);
		ScreenShot.takeScreenshot(DriverInstance.getDriver(), "interest_principle_amount");
	}
}
