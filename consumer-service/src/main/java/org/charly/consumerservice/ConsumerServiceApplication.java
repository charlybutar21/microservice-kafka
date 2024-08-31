package org.charly.consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ConsumerServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
        logger.info("Running...");
    }

}
