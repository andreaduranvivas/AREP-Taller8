package edu.arep.persistence;

import com.mongodb.client.model.Sorts;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class StreamPersistence {
    @Inject
    MongoConnection client;

    public List<Document> getLastPosts(){
        return client.getCollection().find().sort(Sorts.descending("_id")).limit(15)
                .into(new ArrayList<>());
    }
}
