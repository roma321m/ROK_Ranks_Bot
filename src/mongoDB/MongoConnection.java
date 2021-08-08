package mongoDB;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;

public class MongoConnection {
	private static final String ROMANS_PASSWORD = "";
	private static final String CONNECTION_STRING = "mongodb+srv://Roman:" + ROMANS_PASSWORD
			+ "@cluster0.ihbmm.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

	public static void makeConnection() {
		Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
		try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
			printDatabases(mongoClient);
			createDocuments(mongoClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createDocuments(MongoClient mongoClient) {
		MongoCollection<Document> kingdoms = mongoClient.getDatabase("test").getCollection("kingdoms");
		List<Document> kingdomsList = new ArrayList<Document>();
		for (int i = 1001; i <= 1005; i++) {
			kingdomsList.add(new Document("kingdom number", i).append("Top 300 power", "").append("top 300 deads", ""));
		}
		// Document doc = new Document("number", "1254");
		// kingdoms.insertOne(doc);
		kingdoms.insertMany(kingdomsList);
	}

	private static void printDatabases(MongoClient mongoClient) {
		List<Document> dbDocuments = mongoClient.listDatabases().into(new ArrayList<>());
		dbDocuments.forEach(document -> System.out.println(document.toJson()));
	}
}
