package edu.arep.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.arep.model.Tweet;
import edu.arep.persistence.MongoConnection;
import edu.arep.service.TweetService;
import edu.arep.persistence.TweetPersistence;

public class TweetLambda implements RequestHandler<Tweet, Tweet> {

    private TweetService service;

    @Override
    public Tweet handleRequest(Tweet tweet, Context context) {
        if (service == null) {
            MongoConnection mongoConnection = new MongoConnection();
            TweetPersistence persistence = new TweetPersistence(mongoConnection);
            service = new TweetService(persistence);
        }
        return service.addTweet(tweet);
    }
}
