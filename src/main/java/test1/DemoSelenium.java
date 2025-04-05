package test1;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DemoSelenium {

	public static void main(String[] args) throws InterruptedException, AWTException {
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        
	        try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            driver.get("https://rahulshettyacademy.com/locatorspractice/");
	            System.out.println(driver.getTitle());
	            System.out.println(driver.getCurrentUrl());
	            driver.manage().window().maximize();
	                driver.findElement(By.id("inputUsername")).sendKeys("megamohan23@gmail.com");
	                driver.findElement(By.name("inputPassword")).sendKeys("mega");
	                driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/button")).click();
	                System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	                driver.findElement(By.linkText("Forgot your password?")).click();
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	                driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[1]")).sendKeys("Mega");
	                driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[2]")).sendKeys("megamohan23@gmail.com");
	                driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[3]")).sendKeys("7397556167");
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	                WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".go-to-login-btn")));
	                loginBtn.click();
	                Thread.sleep(2000);
	                driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	                WebElement staticdropdown = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
	                Select dropdown = new Select(staticdropdown);
	                dropdown.selectByIndex(1);
	                System.out.println(dropdown.getFirstSelectedOption().getText());
	                
	                 Thread.sleep(1000);
	                 driver.findElement(By.id("divpaxinfo")).click();
	                 int adult=1;
	                 while(adult<5)
	                 {
	                	 driver.findElement(By.id("hrefIncAdt")).click();
	                	 adult++;
	                 }
	                 driver.findElement(By.id("btnclosepaxoption")).click();
	                

	                 WebDriverWait waitbutton = new WebDriverWait(driver, Duration.ofSeconds(10));

	                 driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	                 WebElement Option1 = waitbutton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[1]/li[9]/a")));
	                 Option1.click();
	               
	                 WebElement Option2 = waitbutton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@value='MAA'])[2]")));
	                 Option2.click();
	                 
	           
	                 //checkbox
	                 driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	                 
	                 System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	               
	                 System.out.println(driver.findElements(By.cssSelector("input[type*='checkbox']")).size());
	                 
	                 //autosuggest
	                 driver.findElement(By.id("autosuggest")).sendKeys("ind");

	                 Thread.sleep(3000);

	                 List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
                     for(WebElement option :options)
	                 {
	                 if(option.getText().equalsIgnoreCase("India"))
	                 {
	                 option.click();
	                 break;
	                 }
	                 }
            

         
       } finally {
	            
            driver.quit();
        }
        }
	}


