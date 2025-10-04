package com.pincone.demo.mongo;


import com.pincone.demo.config.NoSQLCollections;
import com.pincone.demo.config.NoSQLConfigProperties;
import com.pincone.demo.model.PineconeRecord;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@AllArgsConstructor
public class FetchProductMongo {

    private final MongoDBClient mongoDBClientImpl;
    private final NoSQLConfigProperties noSQLConfigProperties;
    private final NoSQLCollections noSQLCollections;

    public List<PineconeRecord> load() {
        var productNextory = mongoDBClientImpl.getMongoCollection(noSQLConfigProperties.getNextoryschema(), noSQLCollections.getProductnextory()).get();
        var pinconeRecords = StreamSupport.stream(productNextory.find().spliterator(), true)
                .filter(Objects::nonNull)
                .peek(System.out::println)
                .map(MongoToPinconeRecordUtility::prepareRecord)
                .toList();
        return pinconeRecords;
    }
}

