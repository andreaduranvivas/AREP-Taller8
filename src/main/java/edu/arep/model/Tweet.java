package edu.arep.model;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Tweet {

    private final String author;
    private final String content;
    private LocalDateTime creationDate;

    public Tweet(String author, String content, LocalDateTime creationDate) {
        this.author = author;
        this.content = content;
        this.creationDate = creationDate;
    }
}
