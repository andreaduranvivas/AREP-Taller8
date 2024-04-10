package edu.arep.model;

import lombok.Data;

@Data
public class Tweet {

    private final String author;
    private final String content;
    private String creationDate;

    public Tweet(String author, String content, String creationDate) {
        this.author = author;
        this.content = content;
        this.creationDate = creationDate;
    }
}
