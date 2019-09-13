package bo_Orderable;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_Piece_Min20 extends Wrapper_methods{
	@Test
	public void BO_Piece_Min20 () throws IOException{
		
		GetBulkOrderURL();
		
		enterTextById("ReaderTicket", "8173355");
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "19");
		selectbyvisibletext_Byname("DateOfVisitMonth", "July");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		
		//Enter series 
		
		enterTextById("Series", "FO 141");
		
		//enter the documenet reference id
		
				enterTextById("DocumentReference1", "FO 141/613");
				enterTextById("DocumentReference2", "FO 141/614");
				enterTextById("DocumentReference3", "FO 141/615");
				enterTextById("DocumentReference4", "FO 141/616");
				enterTextById("DocumentReference5", "FO 141/617");
				enterTextById("DocumentReference6", "FO 141/618");
				enterTextById("DocumentReference7", "FO 141/619");
				enterTextById("DocumentReference8", "FO 141/620");
				enterTextById("DocumentReference9", "FO 141/621");
				enterTextById("DocumentReference10", "FO 141/622");
				enterTextById("DocumentReference11", "FO 141/623");
				enterTextById("DocumentReference12", "FO 141/624");
				enterTextById("DocumentReference13", "FO 141/625");
				enterTextById("DocumentReference14", "FO 141/626");
				enterTextById("DocumentReference15", "FO 141/627");
				enterTextById("DocumentReference16", "FO 141/628");
				enterTextById("DocumentReference17", "FO 141/629");
				enterTextById("DocumentReference18", "FO 141/630");
				enterTextById("DocumentReference19", "FO 141/631");
				enterTextById("DocumentReference20", "FO 141/632");
				
				
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
			    
			    
			  String text =  getTextByXpath("//div[@class='emphasis-block success']");
			  
			  System.out.println("BO_Piece_Min20 - "+text);
			  
			  Assert.assertTrue(text.contains("Your bulk order has been successfully submitted."));
			  
			  
			  quitBrowser();
				
		
				
	}
	
	}
	
	


