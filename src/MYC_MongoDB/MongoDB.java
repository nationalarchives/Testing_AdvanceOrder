package MYC_MongoDB;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


public class MongoDB {

	public static void main(String[] args) throws Exception{
	
		MongoClient mongoClient  = new MongoClient(new MongoClientURI("mongodb://dbadmin:b1df6bej@wb-t-data1.web.local:27017,wb-t-data2.web.local:27017"));
		
		//MongoDatabase db = mongoClient.getDatabase("iadata");
		DB db = mongoClient.getDB("iadata");
		System.out.println("connected to Database");
		
DBCollection coll = db.getCollection("Records_MYC");

//DBCursor  cursor = coll.find({IAID:"58e6753d9181068b9b672554"});

DBCursor  cursor = (DBCursor) coll.find().getQuery();

//System.out.println(cursor.limit(10));


/*while(cursor.hasNext()){
	
	int i=10;
	System.out.println(cursor.next());
	i++;
}*/


/*while(cursor.hasNext()){
	
	int i=1;
	System.out.println(cursor.next());
	i++;
	
	
}*/




	}
}




		
	
