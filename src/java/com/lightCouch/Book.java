package com.lightCouch;

import org.ektorp.support.CouchDbDocument;

public class Book extends CouchDbDocument {

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
}
