package MYC_InvalidUpload;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class ValidationCheck_ChangeColumName extends Wrapper_methods{
	
	@Test
	
	public void ChangeColumName() throws IOException, InterruptedException{
		
		launchDriver("http://test.manage-collections.nationalarchives.gov.uk/", "chrome");
		
		SingleSignOn();
		
		clickbyXpath("//table[@id='tblActions']/tbody/tr[1]");
		
		clickbyLinkText("Add a collection");
		
		Thread.sleep(3000);
		
		clickbyLinkText("Upload file");
		Thread.sleep(3000);
		clickbyXpath("//div[@class='breather']/label/strong");
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\hparupalli\\AutoIt_MYC\\ChangeColumName.exe");
		Thread.sleep(3000);
		clickbyXpath("//input[@value='Upload']");
		Thread.sleep(3000);
		clickbyLinkText("View history");
		
		clickbyXpath("(//button[@class='discoveryPrimaryCallToActionLink'])[2]");
		Thread.sleep(3000);
//		clickbyLinkText("See error report >");
		driver.executeScript("scroll(0,1600)");
		clickbyXpath("//a[contains(text(),'See error report >')]");
		Thread.sleep(6000);
		String Actual_Error = getTextByXpath("*");
		
		System.out.println("ChangeColumName "+Actual_Error);
		//System.out.println("test"Actual_Error);
		Assert.assertTrue(Actual_Error.contains("We require a valid level hierarchy in this field. It is not possible to have sub-sub-sub-series directly under series"));
		quitBrowser();
		
		
		
		
	}
	
	

}
