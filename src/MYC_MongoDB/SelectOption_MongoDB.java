package MYC_MongoDB;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class SelectOption_MongoDB {
	public static void main(String[] args) throws Exception{
	MongoClient mongoClient  = new MongoClient(new MongoClientURI("mongodb://dbadmin:b1df6bej@wb-t-data1.web.local:27017,wb-t-data2.web.local:27017"));
	
	DB db = mongoClient.getDB("iadata");
	System.out.println("connected to Database");
	
	DBObject coll = db.getCollection("Records_MYC").findOne();
	System.out.println("The first value is "+coll);
	
	 BasicDBObject whereQuery = new BasicDBObject();
	   // whereQuery.put("AcsConds", "<date>date</date>");
	    whereQuery.put("IAID", "4436825a-7828-4abf-924d-b53d70d81194");
	    BasicDBObject fields = new BasicDBObject();
	    //fields.put("IAID", "4436825a-7828-4abf-924d-b53d70d81194");
	    fields.put("AcsConds", "<date>date</date>");
	  
	 
		DBCursor cursor = db.getCollection("Records_MYC").find(whereQuery, fields);
	    while (cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }
	}
}
	

	   
	
	



