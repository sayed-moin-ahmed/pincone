package com.pincone.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;


@ConfigurationProperties(prefix = "mongo.collection")
@Validated
public class NoSQLCollections {
	private String productnextory;
}
