package edu.arep.service;

import edu.arep.model.Tweet;
import edu.arep.persistence.TweetPersistence;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class TweetServiceTest {

    @Test
    void testAddTweet() {
        TweetPersistence mockPersistence = Mockito.mock(TweetPersistence.class);
        LocalDateTime now = LocalDateTime.now();
        Tweet tweet = new Tweet("TestAuthor", "TestContent", now.toString());
        TweetService service = new TweetService();
        service.persistence = mockPersistence;

        Tweet result = service.addTweet(tweet);

        assertEquals(tweet, result);

        Document expectedDoc = new Document("author", "TestAuthor")
                .append("content", "TestContent")
                .append("creationDate", tweet.getCreationDate());
        verify(mockPersistence).insertTweet(expectedDoc);
    }
}
