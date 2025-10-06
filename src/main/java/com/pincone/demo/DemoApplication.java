package com.pincone.demo;

import com.pincone.demo.setup.MongoToPinconeETL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

@Slf4j
@ConfigurationPropertiesScan("com.pincone.demo.config")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
    }

}
