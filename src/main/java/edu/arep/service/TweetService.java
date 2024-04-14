package edu.arep.service;

import edu.arep.model.Tweet;
import edu.arep.persistence.TweetPersistence;
import org.bson.Document;


public class TweetService {
    private TweetPersistence persistence;

    public TweetService(TweetPersistence persistence) {
        this.persistence = persistence;
    }

    public Tweet addTweet(Tweet tweet){
        Document doc = new Document();
        doc.put("author", tweet.getAuthor());
        doc.put("content", tweet.getContent());
        doc.put("creationDate", tweet.getCreationDate());
        persistence.insertTweet(doc);

        return tweet;
    }
}
