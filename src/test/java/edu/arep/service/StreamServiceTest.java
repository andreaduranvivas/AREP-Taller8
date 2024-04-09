package edu.arep.service;

import edu.arep.persistence.StreamPersistence;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class StreamServiceTest {

    @Test
    void testGetLastPosts() {
        StreamPersistence mockPersistence = Mockito.mock(StreamPersistence.class);

        Document doc1 = new Document("author", "Author1").append("content", "Content1").append("date", "2024-04-09");
        Document doc2 = new Document("author", "Author2").append("content", "Content2").append("date", "2024-04-08");
        List<Document> mockPosts = Arrays.asList(doc1, doc2);
        when(mockPersistence.getLastPosts()).thenReturn(mockPosts);

        StreamService service = new StreamService();
        service.persistence = mockPersistence;
        List<Document> result = service.getLastPosts();

        assertEquals(2, result.size());
        assertEquals("Author1", result.get(0).get("author"));
        assertEquals("Content1", result.get(0).get("content"));
        assertEquals("2024-04-09", result.get(0).get("date"));
        assertEquals("Author2", result.get(1).get("author"));
        assertEquals("Content2", result.get(1).get("content"));
        assertEquals("2024-04-08", result.get(1).get("date"));
    }
}
