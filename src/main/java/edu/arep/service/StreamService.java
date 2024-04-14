package edu.arep.service;

import edu.arep.persistence.StreamPersistence;
import org.bson.Document;

import java.util.List;
import java.util.stream.Collectors;

public class StreamService {
    private StreamPersistence persistence;

    public StreamService(StreamPersistence persistence) {
        this.persistence = persistence;
    }

    public List<Document> getLastPosts(){
        return persistence.getLastPosts().stream().map((Document d) -> {
            Document newDocument = new Document();
            newDocument.put("author", d.get("author"));
            newDocument.put("content", d.get("content"));
            newDocument.put("creationDate", d.get("creationDate"));
            return newDocument;
        }).collect(Collectors.toList());
    }
}
