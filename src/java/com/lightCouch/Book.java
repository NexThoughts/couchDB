package com.lightCouch;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.CouchDbDocument;

public class Book extends CouchDbDocument {

    public enum Genre {THRILLER, FICTION, ROMANCE}

    private Genre genre;
    String name;
    String author;
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @JsonCreator
    public Book(@JsonProperty("name") String name, @JsonProperty("author") String author, @JsonProperty("genre") Genre g) {
        genre = g;
        this.name = name;
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book() {
    }
}
