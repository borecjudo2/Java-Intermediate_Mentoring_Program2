package com.epam.task2.repo;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class MongoRepo {

  private static final String HOST = "127.0.0.1";
  private static final int PORT = 27017;
  private static final String AUTH_DB_NAME = "admin";
  private static final String DB_NAME = "task2";
  private static final String USER = "rootuser";
  private static final String PASSWORD = "rootpass";

  protected final Datastore datastore;


  public MongoRepo() {
    MongoClient mongoClient = MongoClients.create(
        new ConnectionString("mongodb://"+USER+":"+PASSWORD+"@"+HOST+":"+PORT+"/"+AUTH_DB_NAME));
    datastore = Morphia.createDatastore(mongoClient, DB_NAME);
    datastore.getMapper().mapPackage("com.epam.task2");
    datastore.ensureIndexes();
  }
}
