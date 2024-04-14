package edu.arep.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.arep.persistence.MongoConnection;
import edu.arep.persistence.StreamPersistence;
import edu.arep.service.StreamService;

public class StreamLambda implements RequestHandler<Object, String> {

    private StreamService service;

    @Override
    public String handleRequest(Object input, Context context) {
        if (service == null) {
            MongoConnection mongoConnection = new MongoConnection();
            StreamPersistence persistence = new StreamPersistence(mongoConnection);
            service = new StreamService(persistence);
        }
        return service.getLastPosts().toString();
    }
}
