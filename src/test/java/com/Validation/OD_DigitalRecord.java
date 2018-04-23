package com.Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class OD_DigitalRecord extends Wrapper_methods{
	@Test
	public void OD_DigitalRecord() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		
		selectbyvisibletext_Byname("DateOfVisitDay", "25");
		selectbyvisibletext_Byname("DateOfVisitMonth", "May");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "hw 25/37");
		
		//enter full name
		
		enterTextById("FullName", "shanthi");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
	    
	    String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul");

		System.out.println("OD_DigitalRecord.java"+actual);
		
		Assert.assertEquals("hw 25/37 - Document is digitised and cannot be ordered. Check the catalogue for more information.", actual);
		
	    	quitBrowser(); 
	    
		
	}

}
