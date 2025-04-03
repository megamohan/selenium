package test1;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tutorial {
	public static void main(String[] args) throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
	     WebDriver driver = new ChromeDriver();
	     driver.get("https://thinking-tester-contact-list.herokuapp.com/");
	     WebElement input = driver.findElement(By.id("signup"));
	     input.click();
	     
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlContains("https://thinking-tester-contact-list.herokuapp.com/addUser")); 
         
         String currentUrl = driver.getCurrentUrl();
         System.out.println(currentUrl);
	     
         WebElement firstname = driver.findElement(By.id("firstName"));
         firstname.sendKeys("mega");
         
         WebElement lastname = driver.findElement(By.id("lastName"));
         lastname.sendKeys("mohan");
         
         String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
         String dynamicEmail = "testuser" + timestamp + "@example.com";
         
         WebElement email = driver.findElement(By.id("email"));
         email.sendKeys(dynamicEmail);
         
         WebElement password = driver.findElement(By.id("password"));
         password.sendKeys("Mega@2318");
         
         WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
         submitButton.click();
         Thread.sleep(3000);
         String redirecturl = driver.getCurrentUrl();
         
         if (redirecturl.equals("https://thinking-tester-contact-list.herokuapp.com/contactList")) {
             System.out.println("Submit button redirection is correct.");
         } else {
             System.out.println("Submit button redirection failed. Current URL: " + driver.getCurrentUrl());
         }
         
         driver.navigate().back();
         WebElement cancelButton = driver.findElement(By.id("cancel"));
         cancelButton.click();
      
         if (driver.getCurrentUrl().equals("https://thinking-tester-contact-list.herokuapp.com/login")) {
             System.out.println("Cancel button redirection is correct.");
         } else {
             System.out.println("Cancel button redirection failed. Current URL: " + driver.getCurrentUrl());
         }
         
         WebDriverWait userlogin = new WebDriverWait(driver, Duration.ofSeconds(10));
         userlogin.until(ExpectedConditions.urlContains("https://thinking-tester-contact-list.herokuapp.com/login")); 
         
         String userloginUrl = driver.getCurrentUrl();
         System.out.println(userloginUrl);
         
         WebElement header = driver.findElement(By.tagName("h1"));
         header.getText();
         
         WebElement useremail = driver.findElement(By.id("email"));
         useremail.sendKeys("megamohan23@gmail.com");
         
         WebElement userpassword = driver.findElement(By.id("password"));
         userpassword.sendKeys("Mega@2318");
         
         WebElement usersubmit = driver.findElement(By.id("submit"));
         usersubmit.click();
         Thread.sleep(10000);
         
         WebDriverWait afterlogin = new WebDriverWait(driver, Duration.ofSeconds(10));
         afterlogin.until(ExpectedConditions.urlContains("https://thinking-tester-contact-list.herokuapp.com/contactList")); 
         
         WebElement loginheader = driver.findElement(By.tagName("h1"));
         System.out.println(loginheader.getText());
         
         WebElement logout = driver.findElement(By.id("logout"));
         logout.click();
         Thread.sleep(10000);
         
         WebDriverWait afterlogout = new WebDriverWait(driver, Duration.ofSeconds(10));
         afterlogout.until(ExpectedConditions.urlContains("https://thinking-tester-contact-list.herokuapp.com/")); 
         
        
        driver.quit(); 
         
	     
	     
	}

}
