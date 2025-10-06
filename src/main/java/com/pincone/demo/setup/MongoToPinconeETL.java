package com.pincone.demo.setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pincone.demo.mongo.FetchProductMongo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@AllArgsConstructor
public class MongoToPinconeETL {

    private final FetchProductMongo fetchProductMongo;

    private final ObjectMapper mapper = new ObjectMapper();

    public void dump(){
        AtomicInteger skippedRecords = new AtomicInteger(0);
        try {

            var index = PinconeSetup.getIndex("pcsk_6Cd7SR_DvYGvKARiWruuRcZSw16ktrdDzWU4mZrSnE8uQzuxbuQxtLoMwq9SBYbpzQwQVg", "product-info",
                    "us-east-1","llama-text-embed-v2" ,"product-info-1hq0mmd.svc.aped-4627-b74a.pinecone.io", fieldMap());

            List<Map<String, String>> allRecords = fetchProductMongo.load()
                    .stream()
                    .map(record ->
                            Map.of(
                                    "id", record.id(),
                                    "vector", toJsonString(record.vector()),
                                    "metadata", toJsonString(record.metadata()),
                                    "chunk_text", record.chunkText()
                            )
                    )
                    .toList();

                try {
                    var testRecord = Map.of(
                            "id", "test-123",
                            "vector", "[0.1, 0.2, 0.3]",
                            "metadata", "{\"source\":\"unit-test\"}",
                            "chunk_text", "Hello Pinecone"
                    );
                    index.upsertRecords("books-namespace", List.of(testRecord));
                    index.upsertRecords("books-namespace", allRecords);
                }catch (Throwable throwable){
                    log.info("Batch Content:{}",mapper.writeValueAsString(allRecords));
                }


            log.info("Total records skipped due to blank or null chunk_text: {}", skippedRecords.get());
        } catch (Throwable e) {
            log.error("Error:",e);
        }
    }
    private String toJsonString( Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            return obj.toString(); // fallback
        }
    }

    private HashMap<String, String> fieldMap() {
        HashMap<String, String> fieldMap = new HashMap<>();
        fieldMap.put("chunk_text","chunk_text");
        return fieldMap;
    }


}
