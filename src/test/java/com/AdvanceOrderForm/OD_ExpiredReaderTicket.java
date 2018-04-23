package com.AdvanceOrderForm;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class OD_ExpiredReaderTicket extends Wrapper_methods{
	@Test
	public void OD_ExpiredReaderTicket() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "8375191");
		
		//enter the date 
		
		selectbyvisibletext_Byname("DateOfVisitDay", "19");
		selectbyvisibletext_Byname("DateOfVisitMonth", "April");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		
		//enter full name
		
		enterTextById("FullName", "shanthi");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("OD_ExpiredReaderTicket.java"+actual);
		  // Assert.assertEquals("Your reader’s ticket has expired or does not exist. Re-register and enter a new ticket number.", actual);
		   
		   Assert.assertEquals("Your reader’s ticket number is not recognised. Check it has been entered correctly. If it has expired, please re-register and enter a new ticket number.", actual);
		   
		quitBrowser();   
	
		
	}

}
