package ad_Orderable;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class OD_OderableWithHotmailGmailOUtlook extends Wrapper_methods{
	@Test(priority=1)
	public void OD_OderableWithHotmail() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		
		/*selectbyvisibletext_Byname("DateOfVisitDay", "21");
		selectbyvisibletext_Byname("DateOfVisitMonth", "June");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		
		SelectTheDate();
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//Enter email id
		
		enterTextById("EmailAddress", "tnadiscovery100@hotmail.com");
		//click term and conditions
		
		//(Removed on 12 june 2018)
				//clickbyID("TermsAndConditions");
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    //click complete order
	    
	    clickbyXpath("//input[@value='Complete order']");
	  
	    //get order complete text
	    
	    String actual =getTextByXpath("//div[@class='entry-content clearfix']/p[1]");
	    //String actual1 =getTextByXpath("//div[@class='entry-content clearfix']/p[2]");
	    
	    System.out.println("OD_OderableWithHotmail"+actual);
	    //System.out.println(actual1);
	    
	    //Assert.assertEquals(actual,"Your document order has been successfully submitted.");
	   
	    Assert.assertEquals(actual,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	quitBrowser();   
	
		
	}

	
	@Test(priority=2)
	public void OD_OderableWithGmail() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		
		/*selectbyvisibletext_Byname("DateOfVisitDay", "21");
		selectbyvisibletext_Byname("DateOfVisitMonth", "June");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		*/
		
		SelectTheDate();
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		enterTextById("EmailAddress", "tnadiscovery100@gmail.com");
		
		//click term and conditions
		
		//(Removed on 12 june 2018)
				//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    //click complete order
	    
	    clickbyXpath("//input[@value='Complete order']");
	  
	    //get order complete text
	    
	    String actual =getTextByXpath("//div[@class='entry-content clearfix']/p[1]");
	    //String actual1 =getTextByXpath("//div[@class='entry-content clearfix']/p[2]");
	    
	    System.out.println("OD_OderableWithGmail"+actual);
	    //System.out.println(actual1);
	    
	    //Assert.assertEquals(actual,"Your document order has been successfully submitted.");
	   
	    Assert.assertEquals(actual,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	quitBrowser();   
	
		
	}


	
	@Test(priority=3)
	public void OD_OderableWithOutlook() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "21");
		selectbyvisibletext_Byname("DateOfVisitMonth", "June");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		enterTextById("EmailAddress", "hparupalli@nationalarchives.gov.uk");
		//click term and conditions
		
		//(Removed on 12 june 2018)
				//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    //click complete order
	    
	    clickbyXpath("//input[@value='Complete order']");
	  
	    //get order complete text
	    
	    String actual =getTextByXpath("//div[@class='entry-content clearfix']/p[1]");
	    //String actual1 =getTextByXpath("//div[@class='entry-content clearfix']/p[2]");
	    
	    System.out.println("OD_OderableWithOutlook"+actual);
	    //System.out.println(actual1);
	    
	   // Assert.assertEquals(actual,"Your document order has been successfully submitted.");
	   
	    Assert.assertEquals(actual,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	quitBrowser();   
	
		
	}

}
