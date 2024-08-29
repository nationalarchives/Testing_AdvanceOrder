package MYC_MongoDB;

import java.util.Set;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import wrappers.Wrapper_methods;

public class MongoDBConstructor extends Wrapper_methods{
	public void MongoDBConstructor(){
		
		MongoClient mongoClient  = new MongoClient(new MongoClientURI("mongodb://username:password@wb-t-data1.web.local:27017,wb-t-data2.web.local:27017"));
		
		//MongoDatabase db = mongoClient.getDatabase("iadata");
		DB db = mongoClient.getDB("iadata");
		System.out.println("connected to Database");
		
		DBCollection coll = db.getCollection("Records_MYC");
//DBCollection coll = db.getCollection("Records_MYC");

		Set<String> colls = db.getCollectionNames();

		for (String s : colls)
		{
		    System.out.println(s);
		}

		/*
		BasicDBObject query = new BasicDBObject("IAID", "4436825a-7828-4abf-924d-b53d70d81194");
		
		//BasicDBObject query = new BasicDBObject("Accruals", "<p>This is a test description.</p>");

		DBCursor cursor = coll.find(query);

		while(cursor.hasNext())
		{
		   System.out.println(cursor.next());
		}
		cursor.close();
}*/
	
	
	BasicDBObject searchQuery = new BasicDBObject();
	//searchQuery.put("IAID", "4436825a-7828-4abf-924d-b53d70d81194");
	//searchQuery.put("$oid", "59d20f9c3d84462af23463db");
	
	//searchQuery.put("Accrls", "<p>This is a test description.</p>");

	DBCollection table = coll;
	DBCursor cursor = table.find(searchQuery);

	while (cursor.hasNext())
	{
		System.out.println(cursor.next());

	}
	cursor.close();
	}
}


