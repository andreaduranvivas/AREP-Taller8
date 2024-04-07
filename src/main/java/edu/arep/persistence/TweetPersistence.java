package edu.arep.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;

@ApplicationScoped
public class TweetPersistence {
    @Inject
    MongoConnection client;

    public void insertTweet(Document doc){
        client.getCollection().insertOne(doc);
    }
}