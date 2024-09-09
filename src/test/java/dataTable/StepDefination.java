package dataTable;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
//import io.cucumber.java.en;


public class StepDefination {
	WebDriver driver=null;
	@Given("the user on the login page")
	public void goToFacebook() {
		//driver =new ChromeDriver();
	//driver.get("https://facebook.com");
		System.out.println("Hello");
		
	}
	@When("user Enter Valid username password")
	public void EnterData()
	{
		//List<List<String>> data=table.raw();
		//System.out.println(data.get(1).get(1));
		System.out.println("Hello");
	}
}
