package com.omer.couponprojmongo.mongoServices;

import com.mongodb.client.MongoCollection;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MongoManager {

    private final MongoTemplate mongoTemplate;

    public boolean isCollectionExists(String name){
        return mongoTemplate.collectionExists(name);
    }

    public MongoCollection<Document> getCollection(String name){
        return mongoTemplate.getCollection(name);
    }

    public MongoCollection<Document> createCollectionIfNotExists(String name){
        return mongoTemplate.collectionExists(name) ? getCollection(name) :
                mongoTemplate.createCollection(name);
    }
}
