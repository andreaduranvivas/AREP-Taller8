package edu.arep.service;

import edu.arep.persistence.StreamPersistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;
import java.util.List;

@ApplicationScoped
public class StreamService {

    @Inject
    StreamPersistence persistence;

    public List<Document> getLastPosts(){
        return persistence.getLastPosts().stream().map((Document d) -> {
            Document newDocument = new Document();
            newDocument.put("author", d.get("author"));
            newDocument.put("content", d.get("content"));
            newDocument.put("date", d.get("date"));
            return newDocument;
        }).toList();
    }
}