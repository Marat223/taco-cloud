package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.Taco;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends MongoRepository<Taco, ObjectId> {


}
