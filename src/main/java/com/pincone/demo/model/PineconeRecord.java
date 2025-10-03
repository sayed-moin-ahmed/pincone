package com.pincone.demo.model;

import java.util.List;
import java.util.Map;

public record PineconeRecord(String id,List<Float>vector,Map<String, String>metadata, String chunkText) {
}
