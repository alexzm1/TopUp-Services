package com.topup.services.config;

import com.mongodb.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;
import java.util.Properties;

/**
 * <b>MongoDBConfig</b>
 * <p>
 * MongoDB Configuration class
 *
 * <p>
 * Host: 127.0.0.1
 * </P>
 * <p>
 * Port: 27017
 * </P>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.topup.services.common.repository")
@EnableMongoRepositories(basePackages = "com.topup.services.common.repository")
public class MongoDBConfig extends AbstractMongoConfiguration {

    //private final static Logger LOG = LoggerFactory
    //		.getLogger(MongoDBConfig.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getDatabaseName() {
        return "topup-db";
    }

    /**
     * Creates a {@link Mongo} instance from the received host
     *
     * @param host
     * @return An instance of {@link Mongo}
     */
    private MongoClient createMongo(String host, MongoCredential credential) {
        //LOG.info(String.format("Mongo DB connected to host: %s", host));
        MongoClientOptions options = MongoClientOptions.builder().build();
        if (credential == null) {
            return new MongoClient(host, options);
        } else {
            return new MongoClient(new ServerAddress(host), credential, options);
        }
    }

    @Override
    public MongoClient mongoClient() {
        try {
            var dbProperties = PropertiesLoaderUtils
                    .loadAllProperties("db.properties");
            MongoCredential credential = MongoCredential.createScramSha1Credential(
                    dbProperties.getProperty("db.username"),
                    getDatabaseName(),
                    dbProperties.getProperty("db.password").toCharArray());
            if (dbProperties != null && !dbProperties.isEmpty()) {
                return createMongo(dbProperties.getProperty("db.host"), credential);
            }
        } catch (IOException e) {
            //TODO: LOG Exception;
        }
        return createMongo("127.0.0.1", null);
    }
}
