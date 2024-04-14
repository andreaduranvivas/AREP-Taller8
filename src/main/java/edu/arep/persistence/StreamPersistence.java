package edu.arep.persistence;

import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class StreamPersistence {

    private MongoConnection client;

    public StreamPersistence(MongoConnection client) {
        this.client = client;
    }

    public List<Document> getLastPosts(){
        return client.getCollection().find().sort(Sorts.descending("_id")).limit(15)
                .into(new ArrayList<>());
    }
}
