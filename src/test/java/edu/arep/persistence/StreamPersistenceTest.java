package edu.arep.persistence;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.mongodb.MongoTestResource;
import jakarta.inject.Inject;
import org.bson.Document;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@QuarkusTestResource(MongoTestResource.class)
class StreamPersistenceTest {

    @Inject
    StreamPersistence persistence;

    @Test
    void testGetLastPostsEmpty() {
        List<Document> lastPosts = persistence.getLastPosts();
        assertFalse(lastPosts.isEmpty(), "La lista de posts no debe estar vacía");

        for (int i = 0; i < lastPosts.size() - 1; i++) {
            Document current = lastPosts.get(i);
            Document next = lastPosts.get(i + 1);
            assertTrue(current.getObjectId("_id").compareTo(next.getObjectId("_id")) > 0,
                    "Los posts deben estar ordenados por _id en orden descendente");
        }
    }
}
