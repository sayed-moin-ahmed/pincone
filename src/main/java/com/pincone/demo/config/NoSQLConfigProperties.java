package com.pincone.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@ConfigurationProperties(prefix = "datasource.mongo")
@Validated
@Component
public class NoSQLConfigProperties {

	private String server;
	private String nextoryschema;

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getNextoryschema() {
		return nextoryschema;
	}

	public void setNextoryschema(String nextoryschema) {
		this.nextoryschema = nextoryschema;
	}

	@Override
	public String toString() {
		return "NoSQLConfigProperties{" +
				"server='" + server + '\'' +
				", nextoryschema='" + nextoryschema + '\'' +
				'}';
	}
}
