package MYC_AcceptableTag;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AcceptableTags extends wrappers.Wrapper_methods{

	public Object[][]readExcel(java.lang.String dataSheetName) throws InvalidFormatException, IOException {


		File src = new File("C:\\Users\\hparupalli\\MYCTestcases\\Data\\MYCAcceptableTags.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		int rowcount = sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getLastCellNum();

		Object[][]obj = new Object[rowcount][cellcount];

		for(int i=1; i<=rowcount; i++)

		{
			XSSFRow row = sheet.getRow(i);

			for(int j=0; j<cellcount; j++)

			{

				XSSFCell cell = row.getCell(j);
				obj[i-1][j]=cell.getStringCellValue();
				System.out.println(cell.getStringCellValue());
			}
		}


		return obj;
	}

	@Test(dataProvider = "Des")

	public void Validtag(java.lang.String Description, java.lang.String Title , java.lang.String Note, java.lang.String Arrangement, java.lang.String ConditionsGoverningAccess, java.lang.String Accruals, java.lang.String BiographicalHistory, String Expected) throws IOException, InterruptedException{
			launchDriver("http://test.manage-collections.nationalarchives.gov.uk/", "chrome");

			SingleSignOn();

			Thread.sleep(3000);

			//driver.executeScript("scroll(0,500");
			//((JavascriptExecutor) driver).executeScript("scroll(0,1000)");

			//clickbyLinkText("A/BFS");
		clickbyXpath("//div[@class='table table-responsive']/table/tbody/tr[1]/td[2]/a");

			//clickbyXpath("//div[@class='table table-responsive']/table/tbody/tr[5]/td[2]/a");
			Thread.sleep(3000);
			clickbyLinkText("Edit in Discovery");
			Thread.sleep(3000);

			// ((JavascriptExecutor) driver).executeScript("scroll(0,400)");

			 clickbyLinkText("Edit this record");
			 Thread.sleep(3000);
			 driver.findElementById("ScopeAndContent").clear();
			 enterTextById("ScopeAndContent",Description );
			 driver.findElementById("Accruals").clear();
			 enterTextById("Accruals", Accruals);
			 driver.findElementById("Note").clear();
			 enterTextById("Note", Note);

		driver.findElementByXPath("//input[@id ='Title']").clear();
			 enterByTextXpath("//input[@id ='Title']", Title);
			 driver.findElementById("Arrangement").clear();
			 enterTextById("Arrangement", Arrangement);
			 driver.findElementById("ConditionsGoverningAccess").clear();
			 enterTextById("ConditionsGoverningAccess", ConditionsGoverningAccess);
			 driver.findElementById("BiographicalHistory").clear();
			 enterTextById("BiographicalHistory", BiographicalHistory);




		 ((JavascriptExecutor) driver).executeScript("scroll(0,3000)");

		 clickbyXpath("//input[@value='Publish changes'][1]");
		 Thread.sleep(5000);
	java.lang.String actual = getTextByXpath("//table[@class='asset-details']/tbody");

	System.out.println(actual);

	Assert.assertEquals(actual, Expected);


		 Thread.sleep(3000);

			driver.close();

		}

	@DataProvider(name="Des")
	public Object[][] Des() throws Exception{

		return readExcel("MYCAcceptableTags");

		}
}


