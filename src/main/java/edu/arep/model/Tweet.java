package edu.arep.model;

import lombok.Data;

@Data
public class Tweet {

    private final String author;
    private final String content;
    private String creationDate;

    public Tweet(String author, String content, String creationDate) {
        if (content.length() > 140) {
            throw new IllegalArgumentException("El contenido del tweet no puede exceder los 140 caracteres.");
        }
        this.author = author;
        this.content = content;
        this.creationDate = creationDate;
    }
}
