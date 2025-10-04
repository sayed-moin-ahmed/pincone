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
            var pinconeRecord = prepareRecord(doc);
            records.add(pinconeRecord);
        }
        return records;
    }

    public static PineconeRecord prepareRecord(Document doc) {
        String docId = doc.getInteger("_id").toString();
        return flattenDocument(doc, docId,  "");
    }

    private static PineconeRecord flattenDocument(Object value, String docId, String parentKey) {
        if (value instanceof Document) {
            Document doc = (Document) value;
            for (String key : doc.keySet()) {
                Object fieldValue = doc.get(key);
                String fullKey = parentKey.isEmpty() ? key : parentKey + "." + key;
                flattenDocument(fieldValue, docId,  fullKey);
            }
        } else if (value instanceof List) {
            List<?> list = (List<?>) value;
            for (int i = 0; i < list.size(); i++) {
                flattenDocument(list.get(i), docId,  parentKey + "[" + i + "]");
            }
        } else if (value != null) {
            PineconeRecord record = new PineconeRecord(
                    UUID.randomUUID().toString(),
                    null,
                    Map.of("mongo_id", docId, "field_name", parentKey),
                    value.toString()
            );
            return record;
        }
        return null;
    }
}
