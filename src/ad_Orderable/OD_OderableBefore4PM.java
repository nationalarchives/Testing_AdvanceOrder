package ad_Orderable;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class OD_OderableBefore4PM extends Wrapper_methods{
	@Test
	public void OD_OderableBefore4PM() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "7940369");
		
		//enter the date 
		SelectTheDate();
		/*
		selectbyvisibletext_Byname("DateOfVisitDay", "12");
		selectbyvisibletext_Byname("DateOfVisitMonth", "June");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		*/
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//(Removed on 12 june 2018)
				//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    //click complete order
	    
	    clickbyXpath("//input[@value='Complete order']");
	  
	    //get order complete text
	    
	    String actual =getTextByXpath("//div[@class='entry-content clearfix']/p[1]");
	   // String actual1 =getTextByXpath("//div[@class='entry-content clearfix']/p[2]");
	    
	    System.out.println("OD_OderableBefore4PM.java"+actual);
	    //System.out.println(actual1);
	    
	    Assert.assertEquals(actual,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	   
	    //Assert.assertEquals(actual1,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	quitBrowser();
	
		
	}

}
