package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.security.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author marat
 */
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);
}
