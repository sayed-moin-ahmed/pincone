package com.pincone.demo.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pincone.demo.model.PineconeRecord;
import org.bson.Document;

public class MongoToPinconeRecordUtility {
    private static List<PineconeRecord> prepareRecords(List<Document> mongoDocs) {
        List<PineconeRecord> records = new ArrayList<>();
        for (Document doc : mongoDocs) {
            String docId = doc.getInteger("_id").toString();
            flattenDocument(doc, docId, records, "");
        }
        return records;
    }

    public static List<PineconeRecord> prepareRecord(Document doc) {
        List<PineconeRecord> records = new ArrayList<>();
        String docId = doc.getInteger("_id").toString();
        flattenDocument(doc, docId, records, "");
        return records;
    }

    private static void flattenDocument(Object value, String docId, List<PineconeRecord> records, String parentKey) {
        if (value instanceof Document) {
            Document doc = (Document) value;
            for (String key : doc.keySet()) {
                Object fieldValue = doc.get(key);
                String fullKey = parentKey.isEmpty() ? key : parentKey + "." + key;
                flattenDocument(fieldValue, docId, records, fullKey);
            }
        } else if (value instanceof List) {
            List<?> list = (List<?>) value;
            for (int i = 0; i < list.size(); i++) {
                flattenDocument(list.get(i), docId, records, parentKey + "[" + i + "]");
            }
        } else if (value != null) {
            PineconeRecord record = new PineconeRecord(
                    UUID.randomUUID().toString(),
                    null,
                    Map.of("mongo_id", docId, "field_name", parentKey),
                    value.toString()
            );
            records.add(record);
        }
    }
}
