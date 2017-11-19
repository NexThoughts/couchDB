package com.lightCouch

import org.ektorp.CouchDbConnector
import org.ektorp.CouchDbInstance
import org.ektorp.http.HttpClient
import org.ektorp.http.StdHttpClient
import org.ektorp.impl.StdCouchDbInstance

class BasicOperations {

    public static void main(String[] args) {
//        insertDoc()
//        readDoc()
//        updateDoc()
        deleteDoc()

    }

    public static void insertDoc() {
        HttpClient client = new StdHttpClient.Builder().url("http://localhost:5984")
                .username("Arif")
                .password("arif_7777").build()
        CouchDbInstance dbInstance = new StdCouchDbInstance(client)
        CouchDbConnector db = dbInstance.createConnector("session_demo", true)
        Book book = new Book()
        book.name = "alert"
        book.author = "james patterson"
        book.id = "001"
        db.create(book)
        println("====${book.revision}======${book.id}==========")
    }
    public static void readDoc() {
        HttpClient client = new StdHttpClient.Builder().url("http://localhost:5984")
                .username("Arif")
                .password("arif_7777").build()
        CouchDbInstance dbInstance = new StdCouchDbInstance(client)
        CouchDbConnector db = dbInstance.createConnector("session_demo", true)
        String id = "c818f3ecdb60be2712640566260021f8"
        Book book = db.get(Book.class, id)
        println "===${book.name}=========${book.author}============"
    }
    public static void updateDoc() {
        HttpClient client = new StdHttpClient.Builder().url("http://localhost:5984")
                .username("Arif")
                .password("arif_7777").build()
        CouchDbInstance dbInstance = new StdCouchDbInstance(client)
        CouchDbConnector db = dbInstance.createConnector("session_demo", true)
        String id = "c818f3ecdb60be2712640566260021f8"
        Book book = db.get(Book.class, id)
        println "befor Update revision id: ${book.revision}"
        book.name = "the deception point"
        book.author = "dan drown"
        db.update(book)
        println "after update, revision id : ${book.revision}"
    }
    public static void deleteDoc() {
        HttpClient client = new StdHttpClient.Builder().url("http://localhost:5984")
                .username("Arif")
                .password("arif_7777").build()
        CouchDbInstance dbInstance = new StdCouchDbInstance(client)
        CouchDbConnector db = dbInstance.createConnector("session_demo", true)
        String id = "c818f3ecdb60be2712640566260021f8"
        Book book = db.get(Book.class, id)
        String revision = book.revision
        db.delete(id,revision) //db.delete(book)
    }
}
