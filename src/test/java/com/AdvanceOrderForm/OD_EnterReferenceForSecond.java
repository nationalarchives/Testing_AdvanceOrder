package com.AdvanceOrderForm;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class OD_EnterReferenceForSecond extends Wrapper_methods{
	@Test
	public void OD_EnterReferenceForSecond() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		
		selectbyvisibletext_Byname("DateOfVisitDay", "19");
		selectbyvisibletext_Byname("DateOfVisitMonth", "April");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference2", "ADM 1/1");
		
		//enter full name
		
		enterTextById("FullName", "shanthi");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//enter by invalid id
		
		enterTextById("EmailAddress", "test@gmail.com");
		
		//click term and conditions
		
		clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println(actual);
		  Assert.assertEquals("Enter a catalogue reference.", actual);
		  
		  String actual1 = getTextById("DocumentReference1-error");
		  
		  System.out.println("OD_EnterReferenceForSecond.java"+actual1);
		  
		  Assert.assertEquals("Enter a catalogue reference.", actual1);
		   
		//quitBrowser();     
	
		
	}

}
