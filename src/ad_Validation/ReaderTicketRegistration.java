package ad_Validation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class ReaderTicketRegistration extends Wrapper_methods {
	@Test
	public void ReaderTicketRegistration() throws IOException,
			InterruptedException, AWTException {

		launchDriver(
				"https://nationalarchives.gov.uk/order-documents-in-advance/",
				"chrome");

		// click apply online for a reader’s ticket

		clickbyLinkText("apply online for a reader’s ticket");
		// switch to sub window
		String parentWindow = driver.getWindowHandle();

		for (String SubWindow : driver.getWindowHandles()) {
			driver.switchTo().window(SubWindow);

		}

		// select proof of name

		selectbyvisibletext_Byname("ProofOfId", "Passport");

		// select expiry date

		selectbyvisibletext_Byname("ProofOfIdExpiryMonth", "10");
		selectbyvisibletext_Byname("ProofOfIdExpiryYear", "2039");

		// Select form of id
		selectbyvisibletext_Byname("ProofOfAddress", "Utility bill");

		// select date of issue

		selectbyvisibletext_Byname("ProofOfAddressIssueMonth", "10");
		selectbyvisibletext_Byname("ProofOfAddressIssueYear", "1998");

		// LastFourDigits

		enterTextById("LastFourDigits", "1234");

		// enter first name

		enterTextById("FirstName", "Test");
		// enter lastname

		enterTextById("Surname", "LastTest");
		// permanent address

		enterTextById("HouseNameNo", "63");
		enterTextById("Street", "LLoyd court");
		enterTextById("Town", "Pinner");
		// enter postcode

		enterTextById("PostCode", "HA5 1EY");

		Thread.sleep(3000);

		// click next step

		clickbyXpath("//input[@name='NextStep']");

		// sele

				
		//Thread.sleep(3000);
		
		//driver.findElementByXPath("/html/body").sendKeys(Keys.F12);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		//robot.keyPress(KeyEvent.VK_F12);
		//robot.keyRelease(KeyEvent.VK_F12);
	/*	 Actions action = new Actions(driver);
		 action.sendKeys(Keys.F12);
		 action.perform();*/
		
		//driver.findElementByXPath("(//script[@type='text/javascript'])[6]");

		//driver.findElementById("videoPlayer").click();
		

		Thread.sleep(3000);
		//driver.findElementById("watchedVideo").submit();
		// JavascriptExecutor js = (JavascriptExecutor)driver;

		// js.executeScript("document.getElementById(\"videoPlayer\").play()");
		// document.getElementsByTagName("video")[0].currentTime += 30;

		// js.executeScript("document.getElementsByTagName(\"videoPlayer\")[0].currentTime += 30");

		/*
		 * driver.findElementById("watchedVideo").submit();
		 * driver.findElementById("watchedVideo").submit();
		 */

		// driver.findElementByXPath("//form[@name='VideoForm']").submit();

		/*
		 * jwplayer(videoPlayerId).onComplete(function () {
		 * $("#watchedVideo").val('true'); $("form[name='VideoForm']").submit();
		 */

		// Assert.assertEquals("The reading rooms are closed on this day. Check our opening times and select a new date.",
		// actual);

		// quitBrowser();

		
		((JavascriptExecutor) driver).executeScript("(#watchedVideo).val('true')");
		
		((JavascriptExecutor) driver).executeScript("form[name='VideoForm']).submit()");
	}

}
