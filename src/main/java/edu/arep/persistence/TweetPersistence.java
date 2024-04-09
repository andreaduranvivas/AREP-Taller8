package edu.arep.persistence;

import com.mongodb.client.MongoCollection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class TweetPersistence {
    @Inject
    MongoConnection client;

    public void insertTweet(Document doc){
        client.getCollection().insertOne(doc);
    }

    public Document getTweetById(ObjectId id) {
        MongoCollection<Document> collection = client.getCollection();
        return collection.find(eq("_id", id)).first();
    }
}