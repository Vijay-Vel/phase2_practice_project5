package steps;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSignInAmazon {
	
	public static WebDriver driver;
	
	@Given("the User is on the amazon home page")
	public void the_user_is_on_the_amazon_home_page() {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.amazon.in/");
	   System.out.println(driver.getTitle());
	}

	@Then("the User hover and clicks on the sign in button on the amazon page")
	public void the_user_hover_and_clicks_on_the_sign_in_button_on_the_amazon_page() {
		WebElement e1 = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
		Actions a = new Actions(driver);
		
		a.moveToElement(e1).perform();

		driver.findElement(By.linkText("Sign in")).click();
	}

	@When("the User enter email as {string} on the amazon page")
	public void the_user_enter_email_as_on_the_amazon_page(String string) {
		
		driver.findElement(By.id("ap_email")).sendKeys(string);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
	}

	@When("the User enter password as {string} on the amazon page")
	public void the_user_enter_password_as_on_the_amazon_page(String string) {
		
		driver.findElement(By.id("ap_password")).sendKeys(string);
	}

	@When("the User clicks on the sign in button on the amazon page")
	public void the_user_clicks_on_the_sign_in_button_on_the_amazon_page() {
	    
		driver.findElement(By.id("signInSubmit")).click();
	}

	@Then("the User captures the error message on the amazon page")
	public void the_user_captures_the_error_message_on_the_amazon_page() {
		String errormsg = driver.findElement(By.xpath("((//div[@class='a-box-inner a-alert-container'])[1])/descendant::h4")).getText();
		System.out.println(errormsg);
	    
	}

	@Then("the User close the amazon page and browser")
	public void the_user_close_amazon_page_and_browser() {
		driver.close();
		}
	@Then("the user hover mobiles and click on apple")
	public void the_user_hover_mobiles_and_click_on_apple() {
		
		driver.findElement(By.linkText("Mobiles")).click();
		
		WebElement mobile = driver.findElement(By.xpath("//*[@id='nav-subnav']/descendant::span[2]"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(mobile).build().perform();
		
		driver.findElement(By.linkText("Apple")).click();
	}

	@Then("the user click on the searched item")
	public void the_user_click_on_the_searched_item() {
		
		driver.findElement(By.partialLinkText("Starlight")).click();
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	
		
		driver.switchTo().window(tabs.get(1));
	    
	}

	@Then("the user click on add to cart")
	public void the_user_click_on_add_to_cart() {
	    
		driver.findElement(By.id("add-to-cart-button")).click();
	}

}
