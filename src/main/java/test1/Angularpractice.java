package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Angularpractice {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Mega");
		driver.findElement(By.name("email")).sendKeys("megamohan23@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Mega@2318");
		driver.findElement(By.id("exampleCheck1")).click();

		Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		dropdown.selectByVisibleText("Female");

		driver.findElement(By.id("inlineRadio2")).click();
		Thread.sleep(1000);
		WebElement dateInput = driver.findElement(By.name("bday"));
		dateInput.sendKeys("23/08/2000");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

		driver.quit();

	}

}
