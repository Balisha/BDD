package Definition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdef {
	WebDriver driver;
	public String URL= "https://www.opencart.com/index.php?route=cms/demo";


	@Given("I should open the browser and navigate to login page")
	public void i_should_open_the_browser_and_navigate_to_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.linkText("Login")).click();
	}
	@When("Enter email {string}")
	public void enter_email(String string) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('input-email').scrollIntoView()");
	   driver.findElement(By.id("input-email")).sendKeys(string);
	}
	@When("Enter password {string}")
	public void enter_password(String string) {
		driver.findElement(By.id("input-password")).sendKeys(string);
	   
	}
	@When("Click on login")
	public void click_on_login() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
	    Thread.sleep(2000);
	    JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('input-pin').scrollIntoView()");
	    driver.findElement(By.id("input-pin")).sendKeys("6767");
	    driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
	}
	@Then("Should navigate to account detail page")
	public void should_navigate_to_account_detail_page() {
	  String str= driver.findElement(By.xpath("//p[contains(text(),'Welcome to OpenCart!')]")).getText();
	  if(str.equalsIgnoreCase("Welcome to OpenCart!")) {
		  System.out.println("Successfully logged in");
	  }
	  else {
		 
		 System.out.println("not successfull");
	  } 
	}
	@Then("Should throw error")
	public void should_throw_error() {
	    String str1 = driver.getCurrentUrl();
	    if(str1.equalsIgnoreCase("https://www.opencart.com/index.php?route=account/login")) {
	    	System.out.println(" No match for E-Mail and/or Password.");
	    }
	    	else
	    	{
	    		System.out.println("no error");
	    	}
	    }
	}


	
	






