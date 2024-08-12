package dataTable;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;


public class StepDefination {
	WebDriver driver=null;
	@Given("^the user on the login page$")
	public void goToFacebook() {
		driver =new ChromeDriver();
		driver.get("https://facebook.com");
		
	}
	@When("^user Enter Valid username password$")
	public void EnterData(DataTable table)
	{
		List<List<String>> data=table.raw();
		System.out.println(data.get(1).get(1));
	}
}
