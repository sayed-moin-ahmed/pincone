package com.pincone.demo;

import lombok.extern.slf4j.Slf4j;
import org.openapitools.db_control.client.ApiException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Slf4j
@ConfigurationPropertiesScan("com.pincone.demo.config")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        try {
            PinconeSetup.setup("pcsk_6Cd7SR_DvYGvKARiWruuRcZSw16ktrdDzWU4mZrSnE8uQzuxbuQxtLoMwq9SBYbpzQwQVg", "developer-quickstart-java",
                    "us-east-1","llama-text-embed-v2" ,"developer-quickstart-java-1hq0mmd.svc.aped-4627-b74a.pinecone.io");
        }catch (Throwable e) {
            log.error("Error:",e);
        }
    }

}
