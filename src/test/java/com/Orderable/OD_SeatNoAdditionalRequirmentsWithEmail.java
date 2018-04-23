package com.Orderable;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class OD_SeatNoAdditionalRequirmentsWithEmail extends Wrapper_methods{
	@Test
	public void OD_SeatNoAdditionalRequirmentsWithEmail() throws IOException, InterruptedException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "7940369");
		
		//enter the date 
		
		selectbyvisibletext_Byname("DateOfVisitDay", "25");
		selectbyvisibletext_Byname("DateOfVisitMonth", "May");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		//additional requirments
		
		enterTextById("SpecialRequirements", "Test additional requirments");
		
		//enter seat no
		
		enterTextById("SeatNumber", "22");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		
		
		//enter full name
		
		enterTextById("FullName", "shanthi_Test");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//enter email
		
		enterTextById("EmailAddress", "shanthi.venkatesh@nationalarchives.gov.uk");
		
		//click term and conditions
		
		clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    //click complete order
	    
	    clickbyXpath("//input[@value='Complete order']");
	  
	    //get order complete text
	    
	    String actual =getTextByXpath("//div[@class='entry-content clearfix']/p[1]");
	   // String actual1 =getTextByXpath("//div[@class='entry-content clearfix']/p[2]");
	    
	    System.out.println("OD_Oderable.java"+actual);
	    //System.out.println(actual1);
	    
	    Assert.assertEquals(actual,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	   
	    //Assert.assertEquals(actual1,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	quitBrowser();   
	    
	    /*Thread.sleep(5000);
	    
	    driver.navigate().refresh();
	
	    
	  String actual1= getTextByXpath("//div[@class='entry-header']");
	  
	  System.out.println(actual1);
	  
	  Assert.assertEquals(actual1,"Order documents in advance");
		*/
	  
	}

}
