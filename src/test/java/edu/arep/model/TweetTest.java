package edu.arep.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TweetTest {

    @Test
    void testTweetCreation() {
        LocalDateTime now = LocalDateTime.now();
        Tweet tweet = new Tweet("John Doe", "Hello, world!", now.toString());

        assertEquals("John Doe", tweet.getAuthor());
        assertEquals("Hello, world!", tweet.getContent());
        assertEquals(now.toString(), tweet.getCreationDate());
    }

    @Test
    void testTweetEqualsAndHashCode() {
        LocalDateTime now = LocalDateTime.now();
        Tweet tweet1 = new Tweet("John Doe", "Hello, world!", now.toString());
        Tweet tweet2 = new Tweet("John Doe", "Hello, world!", now.toString());

        assertEquals(tweet1, tweet2);
        assertEquals(tweet1.hashCode(), tweet2.hashCode());
    }

    @Test
    void testTweetToString() {
        LocalDateTime now = LocalDateTime.now();
        Tweet tweet = new Tweet("John Doe", "Hello, world!", now.toString());

        String expectedToString = "Tweet(author=John Doe, content=Hello, world!, creationDate=" + now + ")";
        assertEquals(expectedToString, tweet.toString());
    }
}