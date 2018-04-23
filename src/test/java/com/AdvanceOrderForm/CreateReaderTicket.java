package com.AdvanceOrderForm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class CreateReaderTicket {
	
	
	@Test
	
	
	public void CreateReaderTicket() throws IOException{
		
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_win32/chromedriver.exe");
	
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		driver.get("https://test.nationalarchives.gov.uk/order-documents-in-advance/");
		
		String parent = driver.getWindowHandle();
		
		
		//click apply online for reader ticket 
		
		driver.findElementByLinkText("apply online for a reader’s ticket").click();
		///clickbyLinkText("apply online for a reader’s ticket");
		
		
		for(String subwindow : driver.getWindowHandles())
		{
			driver.switchTo().window(subwindow);
			
		
		}
		
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

}
