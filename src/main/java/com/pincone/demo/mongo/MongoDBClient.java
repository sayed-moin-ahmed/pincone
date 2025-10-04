/**
 * 
 */
package com.pincone.demo.mongo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Optional;

public interface MongoDBClient {

	String	MONGO_PRODUCT_VIEW_COLLECTIONS = "product_nextory";

	
	Optional<MongoClient>  getMongoClient();
	Optional<MongoDatabase> getMongoDatabase(String databaseName);
	Optional<MongoCollection<Document>> getMongoCollection(String databaseName,String collection);
}
