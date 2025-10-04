package com.pincone.demo.setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pincone.demo.mongo.FetchProductMongo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@AllArgsConstructor
public class MongoToPinconeETL {

    private final FetchProductMongo fetchProductMongo;

    private final ObjectMapper mapper = new ObjectMapper();

    public void dump(){
        try {

            var index = PinconeSetup.getIndex("pcsk_6Cd7SR_DvYGvKARiWruuRcZSw16ktrdDzWU4mZrSnE8uQzuxbuQxtLoMwq9SBYbpzQwQVg", "product-info",
                    "us-east-1","llama-text-embed-v2" ,"developer-quickstart-java-1hq0mmd.svc.aped-4627-b74a.pinecone.io", fieldMap());

            List<Map<String, String>> allRecords = fetchProductMongo.load()
                    .stream()
                    .map(record ->
                            Map.of(
                                    "id", record.id(),
                                    "vector", toJsonString(record.vector()),
                                    "metadata", toJsonString(record.metadata()),
                                    "text", record.chunkText()
                            )
                    )
                    .toList();
            int batchSize = 95;
            for (int i = 0; i < allRecords.size(); i += batchSize) {
                List<Map<String, String>> batch = allRecords.subList(i, Math.min(i + batchSize, allRecords.size()));
                index.upsertRecords("books-namespace", batch);
            }

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

        fieldMap.put("_id", "id");
        fieldMap.put("isbn", "isbn_code");
        fieldMap.put("activeonnest", "active_on_nest");
        fieldMap.put("aptusid", "aptus_id");
        fieldMap.put("authors", "authors_list");
        fieldMap.put("authorslug", "authors_slug");
        fieldMap.put("book_type", "book_type");
        fieldMap.put("categoryids", "category_ids");
        fieldMap.put("description", "text");
        fieldMap.put("filedeletedate", "file_delete_date");
        fieldMap.put("formats", "formats");
        fieldMap.put("image", "image_info");
        fieldMap.put("language", "language");
        fieldMap.put("market_details", "market_details");
        fieldMap.put("narrators", "narrators_list");
        fieldMap.put("netpriceupdatedon", "net_price_updated_on");
        fieldMap.put("productstatus", "product_status");
        fieldMap.put("producttype", "product_type");
        fieldMap.put("publisheddate", "published_date");
        fieldMap.put("publisher", "publisher_info");
        fieldMap.put("ratings", "ratings_info");
        fieldMap.put("title", "book_title");
        fieldMap.put("title_cleansed", "title_cleansed");
        fieldMap.put("titleslug", "title_slug");
        fieldMap.put("translators", "translators_list");
        fieldMap.put("updateddate", "updated_date");
        fieldMap.put("content_type", "content_type");
        fieldMap.put("authors_ids", "authors_ids");
        fieldMap.put("blurb", "blurb_text");
        fieldMap.put("guided_view", "guided_view");
        fieldMap.put("is_free", "is_free");
        fieldMap.put("narrators_ids", "narrators_ids");
        fieldMap.put("popularity_score", "popularity_score");
        fieldMap.put("preview", "preview");
        fieldMap.put("product_classification", "product_classification");
        fieldMap.put("moirai_id", "moirai_id");
        fieldMap.put("markets", "markets");
        fieldMap.put("syncdate", "sync_date");
        fieldMap.put("updateddate_iso", "updated_date_iso");
        fieldMap.put("filedeletedate_iso", "file_delete_date_iso");
        fieldMap.put("text", "chunk_text");
        return fieldMap;
    }


}
