package com.AdvanceOrderForm;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class OD_Missing extends Wrapper_methods{
	@Test
	public void OD_Missing() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		
		selectbyvisibletext_Byname("DateOfVisitDay", "19");
		selectbyvisibletext_Byname("DateOfVisitMonth", "April");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "HO 45/9682/A48113");
		
		//enter full name
		
		enterTextById("FullName", "shanthi");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		 	    
	    String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("OD_Missing.java"+actual);
		   
		  Assert.assertEquals("HO 45/9682/A48113 - This document cannot be ordered. Check the catalogue for more information.", actual);
		   
		quitBrowser(); 
	    
		
	}

}
