package edu.arep.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.arep.model.Tweet;
import edu.arep.service.TweetService;
import jakarta.inject.Inject;

public class TweetLambda implements RequestHandler<Tweet, Tweet> {

    @Inject
    public TweetService service;

    @Override
    public Tweet handleRequest(Tweet tweet, Context context) {
        return service.addTweet(tweet);
    }
}
