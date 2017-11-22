package com.lightCouch

import org.ektorp.CouchDbConnector
import org.ektorp.CouchDbInstance
import org.ektorp.http.HttpClient
import org.ektorp.http.StdHttpClient
import org.ektorp.impl.StdCouchDbInstance

class Utility {

    public static final String COUCH_DB_URL = "http://localhost:5984"
    public static final String USERNAME = "Arif"
    public static final String PASSWORD = "arif_7777"
    public static final String DATABASE_NAME = "session_demo"

    public static CouchDbConnector getConnection() {
        HttpClient client = new StdHttpClient.Builder().url(COUCH_DB_URL)
                .username(USERNAME)
                .password(PASSWORD).build()
        CouchDbInstance dbInstance = new StdCouchDbInstance(client)
        CouchDbConnector db = dbInstance.createConnector(DATABASE_NAME, true)
        return db
    }
}
