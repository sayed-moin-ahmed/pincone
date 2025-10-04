/**
 * 
 */
package com.pincone.demo.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pincone.demo.config.NoSQLConfigProperties;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.pojo.Conventions.ANNOTATION_CONVENTION;

@Service("mongoDBClientImpl")
public class MongoDBClientImpl implements MongoDBClient{

	@Autowired
	private NoSQLConfigProperties noSQLConfigProperties;

	public static final Predicate<String> notNullEmpty = val->(Objects.nonNull(val) && !val.isEmpty());

	private Optional<MongoClient> mongoClients;

	public Optional<MongoClient> getInstance() {
		String mongodbhost= noSQLConfigProperties.getServer();
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build())); // this is optional
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString(mongodbhost))
				.codecRegistry(pojoCodecRegistry)
				.serverApi(ServerApi.builder().version(ServerApiVersion.V1).strict(true).deprecationErrors(true).build())
				.build();
		mongoClients =Optional.ofNullable(MongoClients.create(settings));
		return mongoClients;
	}

	@Override
	public Optional<MongoClient> getMongoClient() {
		mongoClients = getInstance();
		return mongoClients;
	}

	@Override
	public Optional<MongoDatabase> getMongoDatabase(String databaseName) {
		if(notNullEmpty.test(databaseName)) {
			if(Objects.nonNull(mongoClients) && mongoClients.isPresent())
				return Optional.ofNullable(mongoClients.get().getDatabase(databaseName).withCodecRegistry(getPojoCodecRegistry()));
			else {
				getMongoClient();
				return Optional.ofNullable(mongoClients.get().getDatabase(databaseName).withCodecRegistry(getPojoCodecRegistry()));
			}
		}
		return Optional.ofNullable(null);
	}

	@Override
	public Optional<MongoCollection<Document>> getMongoCollection(String databaseName, String collection) {
		if(notNullEmpty.test(databaseName)&&notNullEmpty.test(collection)) {
			if(Objects.nonNull(mongoClients)&&mongoClients.isPresent()) {
				return createCollection(databaseName, collection);
			}else {
				getMongoClient();
				return createCollection(databaseName, collection);
			}
		}
		return Optional.ofNullable(null);
	}

	private Optional<MongoCollection<Document>> createCollection(String databaseName, String collection) {
		MongoDatabase database = mongoClients.get().getDatabase(databaseName);
		CodecRegistry pojoCodecRegistry = getPojoCodecRegistry();
		database = database.withCodecRegistry(pojoCodecRegistry);
		return Optional.ofNullable(database.getCollection(collection));
	}

	private <T> MongoCollection<T> createCollection(String databaseName, String collection,Class<T> clz) {
		MongoDatabase database = mongoClients.get().getDatabase(databaseName);
		CodecRegistry pojoCodecRegistry = getPojoCodecRegistry();
		database = database.withCodecRegistry(pojoCodecRegistry);
		return database.getCollection(collection,clz);
	}


	private CodecRegistry getPojoCodecRegistry() {
		return fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),fromProviders(PojoCodecProvider.builder().conventions(Arrays.asList(ANNOTATION_CONVENTION)).automatic(true).build()));
	}

}
