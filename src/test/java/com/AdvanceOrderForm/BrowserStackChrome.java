package com.AdvanceOrderForm;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import wrapper.Wrapper_methods;

public class BrowserStackChrome {

	
		
		  public static final String USERNAME = "emmabayne";
		  public static final String AUTOMATE_KEY = "NuCceJunBumUR6nLqu63";
		  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  
		  public static void main(String[] args) throws MalformedURLException, InterruptedException {
			  
		   // DesiredCapabilities caps = new DesiredCapabilities();
			  
			  DesiredCapabilities caps=new DesiredCapabilities();
			  
			 // caps.setPlatform(Platform.XP);
			  
			  /*caps.setCapability("browser", "Chrome");
			    caps.setCapability("browser_version", "49");*/
		    
		caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "49");
		    //caps.setCapability("os", "Android");
		    //caps.setCapability("os_version", "XP");
		    caps.setCapability("browserstack.debug", "true");
			  
			  caps.setCapability("browserstack.debug", "true");

		    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		    driver.get("https://test.nationalarchives.gov.uk/order-documents-in-advance/");
			
	        driver.findElement(By.id("ReaderTicket")).sendKeys("8912657");
			
			//driver.findElementById("ReaderTicket").sendKeys("100");
			//enter the date 
	        Select Day = new Select(driver.findElement(By.name("DateOfVisitDay")));
			List<WebElement> alloptions = Day.getOptions();
			Day.selectByVisibleText("6");
			
			Thread.sleep(3000);
			 Select Month = new Select(driver.findElement(By.name("DateOfVisitMonth")));
				List<WebElement> alloptions1 = Month.getOptions();
				Month.selectByVisibleText("February");
				Thread.sleep(3000);
				 Select DateOfVisitYear = new Select(driver.findElement(By.name("DateOfVisitYear")));
					List<WebElement> alloptions2 = DateOfVisitYear.getOptions();
					DateOfVisitYear.selectByVisibleText("2018");
			
			
			//enter the documenet reference id
			
			driver.findElement(By.id("DocumentReference1")).sendKeys("adm 1/1");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
			
			driver.findElement(By.id("SeatNumber")).sendKeys("100");
			
			
			
			driver.findElement(By.linkText("floor plan")).click();
			
			//driver.findElement(By.linkText("floor plan")).click();
			
			String parentwindow = driver.getWindowHandle();
			for(String Subwindow :driver.getWindowHandles())
			{
				driver.switchTo().window(Subwindow);
			}
			
			System.out.println(driver.getCurrentUrl());
			
			//driver.close();
			
			driver.switchTo().window(parentwindow);
			
			
			
			//enter full name
			
					driver.findElement(By.id("FullName")).sendKeys("shanthi");
					//enter phone number
					driver.findElement(By.id("TelephoneNumber")).sendKeys("078012876");
					driver.findElement(By.id("EmailAddress")).sendKeys("shanvivenkatesh@gmail.com");
					
					
					//click term and conditions
					//driver.findElementById("TermsAndConditions").click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@name='TermsAndConditions'][1]")).click();
					
					//click to continue
					Thread.sleep(3000);
				    driver.findElement(By.xpath("//input[@value='Continue']")).click();;
					
				    //click complete order
				    Thread.sleep(3000);
				    driver.findElement(By.xpath("//input[@value='Complete order']")).click();;
				    Thread.sleep(3000);
				    //get order complete text
				    
				    String actual =driver.findElement(By.xpath("//div[@class='entry-content clearfix']/p[1]")).getText();
				    String actual1 =driver.findElement(By.xpath("//div[@class='entry-content clearfix']/p[2]")).getText();
				    
				    System.out.println(actual);
				    System.out.println(actual1);
				    
				    Assert.assertEquals(actual,"Your document order has been successfully submitted.");
				   
				    Assert.assertEquals(actual1,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
				    
				    driver.quit();
		}


}
