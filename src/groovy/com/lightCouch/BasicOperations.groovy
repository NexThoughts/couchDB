package com.lightCouch

import org.ektorp.CouchDbConnector

class BasicOperations {

    public static void main(String[] args) {
//        insertDoc()
//        readDoc()
//        updateDoc()
        deleteDoc()

    }

    public static void insertDoc() {

        CouchDbConnector db = Utility.getConnection()
        Book book = new Book("the broker", "james patterson", Book.Genre.THRILLER)
        book.id = "011"
        db.create(book)
        println("====${book.revision}======${book.id}==========")
    }

    public static void readDoc() {
        CouchDbConnector db = Utility.getConnection()
        String id = "011"
        Book book = db.get(Book.class, id)
        println "===${book.name}=========${book.author}============"
    }

    public static void updateDoc() {
        CouchDbConnector db = Utility.getConnection()
        String id = "011"
        Book book = db.get(Book.class, id)
        println "befor Update revision id: ${book.revision}"
        book.name = "the deception point"
        book.author = "dan drown"
        book.genre = Book.Genre.FICTION
        db.update(book)
        println "after update, revision id : ${book.revision}"
    }

    public static void deleteDoc() {
        CouchDbConnector db = Utility.getConnection()
        String id = "011"
        Book book = db.get(Book.class, id)
        String revision = book.revision
        db.delete(id, revision) //db.delete(book)
        println "deleted book...with id ${id}"
    }
}
