package test1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartPractice {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		int j=0;
		String[] veg = {"Cucumber","Brocolli","Beetroot"};
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i =0;i< products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			List items = Arrays.asList(veg);
			
			if(items.contains(formattedName))
			{
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==veg.length)
				{
					break;
				}
			}
		}
	       
	}

}
