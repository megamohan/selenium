package test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public  static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.findElement(By.id("name")).sendKeys("Mega");
		 driver.findElement(By.id("alertbtn")).click();
		 Thread.sleep(1000);
		 System.out.println(driver.switchTo().alert().getText());
		 driver.switchTo().alert().accept();
		 driver.findElement(By.id("confirmbtn")).click();
		 System.out.println(driver.switchTo().alert().getText());
		 driver.switchTo().alert().dismiss();
	
	 
		 
		 
	//autosuggestion
		 
		 driver.findElement(By.id("autocomplete")).sendKeys("India");
		 List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item-wrapper']"));
		 for(WebElement option : options)
		 {
			 if(option.getText().equalsIgnoreCase("India"));
			 {
				 option.click();
				 break;
			 }
		 }
	 
//		 //checkbox
		 
		 driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).click();
		 System.out.println( driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		 System.out.println(driver.findElements(By.cssSelector("input[type*='checkbox']")).size());	 
	 
//		 //dropdown
		 
		 WebElement dropdown1 =  driver.findElement(By.id("dropdown-class-example"));
		 Select dropdown = new Select(dropdown1);
		 dropdown.selectByIndex(1);
		 System.out.println(dropdown.getFirstSelectedOption().getText());
		
	 
//		 //open window 
		 
        WebElement openwindow = wait.until(ExpectedConditions.elementToBeClickable(By.id("openwindow")));
        Thread.sleep(2000);
  
         
         //radio button
         driver.findElement(By.xpath("//*[@id=\"radio-btn-example\"]/fieldset/label[1]/input")).click();
         System.out.println( driver.findElement(By.xpath("//*[@id=\"radio-btn-example\"]/fieldset/label[1]/input")).isSelected());
         

		 driver.quit();
		 
		 
		 
	}
}
