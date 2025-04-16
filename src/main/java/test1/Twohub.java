package test1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class Twohub {
    public static void main(String[] args) {
    	
    	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();

        try {
            driver.get("https://www.tripclap.com/partner/2hub-travel");

            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.id("tocity_1")));
            inputField.clear();
            inputField.sendKeys("Bangalore");

         
            List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.cssSelector("li.autoComplete_result")));

            boolean citySelected = false;

            for (WebElement option : suggestions) {
                String text = option.getText().trim();
                System.out.println("Found: " + text);

                if (text.equalsIgnoreCase("Bangalore, Karnataka, India")) {
                    try {
                       
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
                        citySelected = true;
                        break;
                    } catch (Exception e) {
                        System.out.println("Failed to click directly, trying actions click.");
                        new Actions(driver).moveToElement(option).click().perform();
                        citySelected = true;
                        break;
                    }
                }
            }

            if (!citySelected) {
                System.out.println("Desired city not found in suggestions.");
            }
            
            
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

            String year = "2025";
            String date = "23";
            String month = "July";
            
            driver.findElement(By.id("fromdate_1")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("qs-datepicker")));

         
         while (true) {
             String currentMonth = driver.findElement(By.xpath("//span[@class='qs-month']")).getText();
             String currentYear = driver.findElement(By.xpath("//span[@class='qs-year']")).getText();

             if (currentMonth.equalsIgnoreCase(month) && currentYear.equalsIgnoreCase(year)) {
                 break;
             }

             
             WebElement nextMonthArrow = wait1.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//div[contains(@class, 'qs-arrow') and contains(@class, 'qs-right')]")));
             nextMonthArrow.click();
             Thread.sleep(500); 
         }
         
         
         List<WebElement> dates = driver.findElements(
                 By.xpath("//div[contains(@class, 'qs-num') and @data-direction='0']"));

         boolean dateClicked = false;
         
         for (WebElement selectDate : dates) {
             if (selectDate.getText().trim().equals(date)) {
            	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectDate);
            	 dateClicked = true;
                 break;
             }
         }
         
         if (!dateClicked) {
        	    System.out.println("Date 23 not found in current calendar month.");
        	}
         Thread.sleep(3000); 
            
         
         WebElement dropdown1 =  driver.findElement(By.id("adults_1"));
   		 Select adult = new Select(dropdown1);
   		 adult.selectByIndex(1);
   		 System.out.println(adult.getFirstSelectedOption().getText());
   		 
   	     WebElement dropdowns =  driver.findElement(By.id("infant_1"));
		 Select infant = new Select(dropdowns);
		 infant.selectByIndex(1);
		 System.out.println(infant.getFirstSelectedOption().getText());
		 
		 
		 WebElement dropdown =  driver.findElement(By.id("children_1"));
		 Select childern = new Select(dropdown);
		 childern.selectByIndex(1);
		 System.out.println(childern.getFirstSelectedOption().getText());
		 
		 driver.findElement(By.id("email_1")).sendKeys("megamohan23@gmail.com");
		 driver.findElement(By.id("phone_1")).sendKeys("7397556167");
		 driver.findElement(By.id("stp1btn_1")).click();
		 Thread.sleep(3000);
	     
		 
		 
		 driver.findElement(By.id("otp_1")).sendKeys("7894");
		 System.out.print(driver.findElement(By.id("otpError_1")).getText());
		 
		 driver.findElement(By.id("verify_otp_button_1")).click();
	        
		 WebElement resend = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resendButton_1")));
		 resend.click();
		 
		 
	        boolean msg = driver.findElement(By.id("resendSuccess_1")).isDisplayed();
	        
	        WebElement otpField =driver.findElement(By.id("otp_1"));
	        otpField.clear();
			 Scanner scanner = new Scanner(System.in);
		        System.out.print("Please enter the OTP you received: ");
		        String otp = scanner.nextLine(); 
		  

		        otpField.sendKeys(otp);        
		        driver.findElement(By.id("verify_otp_button_1")).click();
		        	        
		        WebElement name = driver.findElement(By.id("name_1"));
		        System.out.print(name.getText());
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("rating5_1")));
		 js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
		 js.executeScript("arguments[0].click();", checkbox);
		 System.out.println(checkbox.isSelected());


		 WebElement flightbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("n01_1")));
		 js.executeScript("arguments[0].scrollIntoView(true);", flightbutton);
		 js.executeScript("arguments[0].click();", flightbutton);
		 System.out.println(flightbutton.isSelected());

		
		 WebElement willBook = wait.until(ExpectedConditions.elementToBeClickable(By.id("just_check_time")));
		 js.executeScript("arguments[0].scrollIntoView(true);", willBook);
		 js.executeScript("arguments[0].click();", willBook);
		 System.out.println(willBook.isSelected());
		 
		 driver.findElement(By.id("stp2btn")).click();
		 
		 
		WebElement skip = wait.until(ExpectedConditions.elementToBeClickable(By.id("skp2")));
		 js.executeScript("arguments[0].scrollIntoView(true);", skip);
		 js.executeScript("arguments[0].click();", skip);
		
		 
		 
		 System.out.print("Enter the 4-digit OTP (e.g., 1234): ");
		 String input = scanner.nextLine().trim();

		 if (input.length() != 4 || !input.matches("\\d{4}")) {
		     System.out.println("Invalid OTP entered. Please enter a valid 4-digit number.");
		 } else {
			 
				 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
				 List<WebElement> otpInputs = wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					        By.xpath("//input[starts-with(@id, 'otp-number-input-')]")));
			 
		     for (int i = 0; i < 4; i++) {
		         String inputChar = String.valueOf(input.charAt(i));
		         WebElement inputBox = otpInputs.get(i);
		         inputBox.clear();
		         inputBox.sendKeys(inputChar);
		     }
		     
		     WebElement verifyBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-cons m-t-10 btn-lg']"));
		     verifyBtn.click();
		 }
			 
		
		 WebElement cancel = wait1.until(ExpectedConditions.elementToBeClickable(
				    By.xpath("(//button[@class='close']//span[text()='×'])[2]")));
		 js.executeScript("arguments[0].scrollIntoView(true);", cancel);
		 js.executeScript("arguments[0].click();", cancel);
		 
        } 
        
        catch (Exception e) {
        	
            e.printStackTrace();
        } 
        
        
        finally {        	
           
        }     
       
    }
}

