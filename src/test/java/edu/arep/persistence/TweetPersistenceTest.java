package edu.arep.persistence;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.mongodb.MongoTestResource;
import jakarta.inject.Inject;
import org.bson.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@QuarkusTestResource(MongoTestResource.class)
class TweetPersistenceTest {

    @Inject
    TweetPersistence tweetPersistence;

    @Test
    void testInsertTweet() {
        Document tweet = new Document("author", "TestAuthor")
                .append("content", "TestContent")
                .append("date", "2024-04-09");

        tweetPersistence.insertTweet(tweet);

        Document insertedTweet = tweetPersistence.getTweetById(tweet.getObjectId("_id"));

        assertNotNull(insertedTweet, "El tweet insertado no debe ser nulo");
        assertEquals("TestAuthor", insertedTweet.getString("author"), "El autor del tweet insertado debe coincidir");
        assertEquals("TestContent", insertedTweet.getString("content"), "El contenido del tweet insertado debe coincidir");
        assertEquals("2024-04-09", insertedTweet.getString("date"), "La fecha del tweet insertado debe coincidir");
    }
}