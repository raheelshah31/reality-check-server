package com.realitycheck.repository;

import com.realitycheck.model.Scoops;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScoopRepository extends MongoRepository<Scoops,String> {
    Scoops findBy_id(ObjectId _id);
}
