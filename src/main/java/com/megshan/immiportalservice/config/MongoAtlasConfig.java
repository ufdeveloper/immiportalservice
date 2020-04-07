package com.megshan.immiportalservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Configuration
public class MongoAtlasConfig {

    @Bean
    public MongoClient mongoClient() throws UnsupportedEncodingException {

        System.out.println("mongodb+srv://immiportalroot:"
                + URLEncoder.encode("qmHr8vPd29rz4e8m", "UTF-8")
                + "@immiportalcluster-hebmd.mongodb.net/sample_airbnb?retryWrites=true&w=majority");
        return MongoClients.create(
                "mongodb+srv://immiportalroot:"
                        + URLEncoder.encode("qmHr8vPd29rz4e8m", "UTF-8")
                        + "@immiportalcluster-hebmd.mongodb.net/sample_airbnb?retryWrites=true&w=majority");
    }
}
