package edu.arep.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.arep.service.StreamService;
import jakarta.inject.Inject;

public class StreamLambda implements RequestHandler<Object, String> {

    @Inject
    public StreamService service;

    @Override
    public String handleRequest(Object input, Context context) {
        return service.getLastPosts().toString();
    }
}
