package org.demo.guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class A {
	public static WebDriver driver;

@Given("launch the browser as well as url and click")
public void launch_the_browser_as_well_as_url_and_click() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajasekar\\Desktop\\number programs\\Prac\\driver\\chromedriver.exe");
   driver=new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("http://demo.guru99.com/telecom/index.html");
   driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
   
}

@When("Enter user details click next {string},{string},{string},{string},{string}")
public void enter_user_details_click_next(String string, String string2, String string3, String string4, String string5) {
driver.findElement(By.xpath("//label[@for='done']")).click();
driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(string);
driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(string2);
driver.findElement(By.xpath("//input[@id='email']")).sendKeys(string3);
driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(string4);
driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(string5);
driver.findElement(By.xpath("//input[@type='submit']")).click();
}

@Then("youll get unique user id")
public void youll_get_unique_user_id() {
  boolean contains = driver.getCurrentUrl().contains("uid");
  System.out.println(contains);
  driver.close();
}



}
