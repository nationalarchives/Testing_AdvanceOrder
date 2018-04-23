package com.AdvanceOrderForm;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class OD_12Documents extends Wrapper_methods{
	@Test
	public void OD_12Documents() throws IOException, InterruptedException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "8912657");
		
		//enter the date 
		
		selectbyvisibletext_Byname("DateOfVisitDay", "20");
		selectbyvisibletext_Byname("DateOfVisitMonth", "April");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		enterTextById("DocumentReference2", "WO 374/2264");
		enterTextById("DocumentReference3", "WO 339/59170");
		enterTextById("DocumentReference4", "WO 374/10464");
		enterTextById("DocumentReference5", "WO 374/10474");
		enterTextById("DocumentReference6", "WO 374/10482");
		enterTextById("DocumentReference7", "WO 339/98317");
		enterTextById("DocumentReference8", "WO 339/99948");
		enterTextById("DocumentReference9", "WO 339/106899");
		enterTextById("DocumentReference10", "WO 339/110570");
		enterTextById("DocumentReference11", "WO 339/72331");
		enterTextById("DocumentReference12", "WO 339/92801");
		
		//enter full name
		
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
	   // String actual1 =getTextByXpath("//div[@class='entry-content clearfix']/p[2]");
	    
	    System.out.println("OD_12Documents.java"+actual);
	    //System.out.println(actual1);
	    
	    Assert.assertEquals(actual,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	   
	    //Assert.assertEquals(actual1,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	//quitBrowser();   
	
	    Thread.sleep(5000);
	    
	    driver.navigate().refresh();
	    
	    String actual1= getTextByXpath("//div[@class='entry-header']");
		  
		  System.out.println(actual1);
		  
		  Assert.assertEquals(actual1,"Order documents in advance");
		
	}
	

}
