package test1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSelenium {

	public static void main(String[] args) throws InterruptedException, AWTException {
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        
	        try {
	          
	            driver.get("https://www.saucedemo.com/");
	            System.out.println(driver.getTitle());
	            System.out.println(driver.getCurrentUrl());
	            driver.manage().window().maximize();
	          
	  
	                driver.findElement(By.id("user-name")).sendKeys("standard_user");

	             
	                driver.findElement(By.id("password")).sendKeys("secret_sauce");

	              
	                driver.findElement(By.id("login-button")).click();
	                

		            List<WebElement> links =driver.findElements(By.tagName("a"));
		            System.out.println("total num of links" + links.size());
		            
		            List<WebElement> image =driver.findElements(By.tagName("img"));
		            System.out.println("total num of links" + image.size());

	             
	                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	                
	                WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
	                menuButton.click();
	                System.out.println("Open Menu button clicked successfully!");
	                Thread.sleep(1000);

	           
	                WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu-wrap")));
	                if (sidebar.isDisplayed()) {
	                    System.out.println("Sidebar menu is visible.");
	                } else {
	                    System.out.println(" Sidebar menu is NOT visible.");
	                }
	                Thread.sleep(1000);

	               
	                String[] menuItems = {"inventory_sidebar_link", "about_sidebar_link", "logout_sidebar_link", "reset_sidebar_link"};

	                for (String itemId : menuItems) {
	                    WebElement menuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(itemId)));
	                    if (menuItem.isDisplayed()) {
	                        System.out.println(menuItem.getText() + "' is present in the menu.");
	                    } else {
	                        System.out.println( itemId + "' is missing in the menu.");
	                    }
	                }

	          
	                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-cross-btn")));
	                closeButton.click();
	                System.out.println("✅ Close Menu (X) button clicked successfully!");
	            
	            
	        } finally {
	            
	            driver.quit();
	        }
	        }
	}


