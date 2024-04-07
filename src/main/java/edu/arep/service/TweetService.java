package edu.arep.service;

import edu.arep.model.Tweet;
import edu.arep.persistence.TweetPersistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;

@ApplicationScoped
public class TweetService {
    @Inject
    TweetPersistence persistence;

    public Tweet addTweet(Tweet tweet){
        Document doc = new Document();
        doc.put("author", tweet.getAuthor());
        doc.put("content", tweet.getContent());
        doc.put("date", tweet.getCreationDate());
        persistence.insertTweet(doc);

        return tweet;
    }
}