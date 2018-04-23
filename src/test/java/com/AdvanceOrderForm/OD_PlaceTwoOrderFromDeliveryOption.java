package com.AdvanceOrderForm;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class OD_PlaceTwoOrderFromDeliveryOption  extends Wrapper_methods {

	
	@Test
	
	public void OD_PlaceTwoOrderFromDeliveryOption() throws IOException{
		
		
		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");
		
		//search the reference 
		
		enterTextById("search-all-collections", "ADm53/53");
		
		//click search option
		
		clickbyXpath("//input[@value='Search'][1]");
		
		//click the first link
		
		clickbyXpath("//ul[@id='search-results']/li[1]");
		
		//click order in advance
		
		clickbyLinkText("Order in advance");
		
enterTextById("ReaderTicket", "8912657");
		
		//enter the date 
		
		selectbyvisibletext_Byname("DateOfVisitDay", "7");
		selectbyvisibletext_Byname("DateOfVisitMonth", "February");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		
		/*//enter full name
		
		enterTextById("FullName", "shanthi");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    //click complete order
	    
	    clickbyXpath("//input[@value='Complete order']");
	  
	    //get order complete text
	    
	    String actual =getTextByXpath("//div[@class='entry-content clearfix']/p[1]");
	    String actual1 =getTextByXpath("//div[@class='entry-content clearfix']/p[2]");
	    
	    System.out.println(actual);
	    System.out.println(actual1);
	    
	    Assert.assertEquals(actual,"Your document order has been successfully submitted.");
	   
	    Assert.assertEquals(actual1,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	//quitBrowser();   
		*/
		
	}
}
