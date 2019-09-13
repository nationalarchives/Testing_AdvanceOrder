package MYC_InvalidUpload;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class ValidationCheck_ModifyLevelName extends Wrapper_methods{
	
	@Test
	
	public void ModifyLevelName() throws IOException, InterruptedException{
		
		launchDriver("http://test.manage-collections.nationalarchives.gov.uk/", "chrome");
		
		SingleSignOn();
		
		clickbyXpath("//table[@id='tblActions']/tbody/tr[1]");
		
		clickbyLinkText("Add a collection");
		
		Thread.sleep(3000);
		
		clickbyLinkText("Upload file");
		Thread.sleep(3000);
		clickbyXpath("//div[@class='breather']/label/strong");
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\hparupalli\\AutoIt_MYC\\ModifyLevelName.exe");
		Thread.sleep(3000);
		clickbyXpath("//input[@value='Upload']");
		Thread.sleep(3000);
		clickbyLinkText("View history");
		clickbyXpath("(//button[@class='discoveryPrimaryCallToActionLink'])[2]");
		Thread.sleep(3000);
		clickbyLinkText("See error report >");
		Thread.sleep(3000);
		String Actual_Error = getTextByXpath("(//div[@class='table table-responsive'])[2]");
		
		System.out.println("ModifyLevelName "+Actual_Error);
		Assert.assertTrue(Actual_Error.contains("Error We expect to see 'fonds' in this field; it currently contains 'fond' 2"));
		quitBrowser();
		
		
		
		
	}
	
	

}
