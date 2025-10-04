package com.pincone.demo;

import io.pinecone.clients.Index;
import io.pinecone.clients.Pinecone;
import io.pinecone.configs.PineconeConfig;
import io.pinecone.configs.PineconeConnection;
import org.openapitools.db_control.client.ApiException;
import org.openapitools.db_control.client.model.CreateIndexForModelRequest;
import org.openapitools.db_control.client.model.CreateIndexForModelRequestEmbed;
import org.openapitools.db_control.client.model.DeletionProtection;
import org.openapitools.db_control.client.model.IndexModel;

import java.util.HashMap;

public class PinconeSetup {

    public static void test(String apiKey, String indexName, String region, String embedModel,String host, String namespace) throws Throwable {
        HashMap<String, String> fieldMap = new HashMap<>();
        fieldMap.put("text", "chunk_text");
        Index index = getIndex(apiKey, indexName, region, embedModel, host,fieldMap);
        index.upsertRecords(namespace, SampleDataSet.prepareDataSet());
    }

    public static Index getIndex(String apiKey, String indexName, String region, String embedModel, String host,HashMap<String, String> fieldMap) throws ApiException {
        PineconeConfig config = new PineconeConfig(apiKey);
        Pinecone pinecone = new Pinecone.Builder(apiKey).build();
        boolean isPresent = pinecone.listIndexes().getIndexes().stream().peek(System.out::println).anyMatch(e->e.getName().equals(indexName));
        // Check if index exists
        if (!isPresent) {
            createIndex(indexName, region, embedModel, pinecone,fieldMap);
        }
        config.setHost(host);
        PineconeConnection connection = new PineconeConnection(config);
        Index index = new Index(config, connection, indexName);
        return index;
    }

    private static void createIndex(String indexName, String region, String embedModel, Pinecone pinecone,HashMap<String,String> fieldMap) throws ApiException {
        CreateIndexForModelRequestEmbed embed = new CreateIndexForModelRequestEmbed()
                .model(embedModel)
                .fieldMap(fieldMap);
        IndexModel indexModel = pinecone.createIndexForModel(
                indexName,
                CreateIndexForModelRequest.CloudEnum.AWS,
                region,
                embed,
                DeletionProtection.DISABLED,
                null
        );
    }

}
