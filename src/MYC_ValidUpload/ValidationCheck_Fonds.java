package MYC_ValidUpload;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class ValidationCheck_Fonds extends Wrapper_methods{
	
	@Test
	
	public void validationcheck() throws IOException, InterruptedException{
		
		launchDriver("http://test.manage-collections.nationalarchives.gov.uk/", "chrome");
		
		SingleSignOn();
		
		clickbyXpath("//table[@id='tblActions']/tbody/tr[1]");
		
		clickbyLinkText("Add a collection");
		
		Thread.sleep(3000);
		//driver.executeScript("scroll(0,300)");
		clickbyLinkText("Upload file");
		Thread.sleep(3000);
		clickbyXpath("//div[@class='breather']/label/strong");
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\hparupalli\\AutoIt_MYC\\Fonds.exe");
		Thread.sleep(3000);
		clickbyXpath("//input[@value='Upload']");
		Thread.sleep(3000);
		clickbyLinkText("View history");
		
		clickbyXpath("(//button[@class='discoveryPrimaryCallToActionLink'])[2]");
		Thread.sleep(3000);
		//clickbyLinkText("Preview and approve >");

		//clickbyXpath("//*[@id=\"page_wrap\"]/div/div/div[2]/form/span/span/button[1]");
		//Thread.sleep(3000);
		//String Actual_Error = getTextByXpath("(//div[@class='table table-responsive'])[2]");
		
		//System.out.println(Actual_Error);
		//Assert.assertTrue(Actual_Error.contains("Expected a valid level hierarchy, can't have item directly under the fonds"));
		//quitBrowser();
		
		//clickbyXpath("//button[@type='button'][1]");
		
		clickbyXpath("(//button[@class='discoveryPrimaryCallToActionLink'])[2]");
		
		String Actual = getTextByXpath("//div[@class='collection upload'][1]");
		System.out.println(Actual);
		
		Assert.assertFalse(Actual.contains("Fonds.xlsx - Upload completed"));
		
		quitBrowser();
		
		
		
	}
	
	

}
