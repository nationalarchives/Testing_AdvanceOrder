package MYC_charactorString;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class CharactorStringVerification extends MYC_MongoDB.MongoDBConstructor {

	@Test

	// public void invalidtag(String Description,String Title ,String Note,
	// String Arrangement, String ConditionsGoverningAccess,String Accruals,
	// String BiographicalHistory) throws IOException, InterruptedException{
	public void stringVerification() throws IOException, InterruptedException {

		launchDriver("http://test.manage-collections.nationalarchives.gov.uk/", "chrome");

		SingleSignOn();

		Thread.sleep(3000);

		clickbyXpath("//div[@class='table table-responsive']/table/tbody/tr[1]/td[2]/a");
		Thread.sleep(3000);
		clickbyLinkText("Edit in Discovery");

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		clickbyLinkText("Edit this record");
		driver.findElementById("ScopeAndContent").clear();

		// enterTextById("ScopeAndContent","<p> this is
		// Description!"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\^_</p>"
		// );

		enterTextById("ScopeAndContent", "This is a test  #$% &'()*+,-./0123456789:;=?@ABCD||EFGHI JKLMNO PQRSTUVWXY|Z[^_/");

		((JavascriptExecutor) driver).executeScript("scroll(0,3000)");

		clickbyXpath("//input[@value='Publish changes'][1]");

		String actual = getTextByXpath("//table[@class='asset-details']/tbody/tr[3]/td");

		System.out.println(actual);

		// Assert.assertEquals("#$% &'()*+,-./0123456789:;=?@ABCD actual);
		MongoClient mongoClient = new MongoClient(
				new MongoClientURI("mongodb://dbadmin:b1df6bej@wb-t-data1.web.local:27017,wb-t-data2.web.local:27017"));
		DB db = mongoClient.getDB("iadata");
		System.out.println("connected to Database");
		DBCollection coll = db.getCollection("Records_MYC");
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("IAID", "b63dc75c-4b22-4bb1-b1a2-929f52af6ae3");
		// searchQuery.put("$oid", "59d20f9c3d84462af23463db");

		// searchQuery.put("Desc", "<p>#$%
		// &'()*+,-./0123456789:;=?@ABCD</p><p>EFGHI JKLMNO
		// PQRSTUVWXY</p><p>Z[^_/</p>");

		DBCollection table = coll;
		DBCursor cursor = table.find(searchQuery);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());

		}
		cursor.close();

		driver.quit();
	}
}
