package edu.arep.persistence;

import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import org.bson.Document;

public class MongoConnection {

    private static final String URL_DATABASE = "mongodb+srv://briancfajardo:admin@cluster0.jyodi8s.mongodb.net/Taller8?retryWrites=true&w=majority";
    private static final String DATABASE_NAME = "Taller8";
    private static final String COLLECTION_NAME = "Tweets";

    private MongoClient client;
    private MongoCollection<Document> TweetsCollection;

    public void connect() {
        this.client = MongoClients.create(new ConnectionString(URL_DATABASE));
        MongoDatabase database = client.getDatabase(DATABASE_NAME);
        this.TweetsCollection = database.getCollection(COLLECTION_NAME);
    }

    public void disconnect() {
        this.client.close();
    }

    public MongoCollection<Document> getCollection(){
        connect();
        return TweetsCollection;
    }
}
