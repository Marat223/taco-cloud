package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.security.User;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marat
 */
public interface UserRepository extends CrudRepository<User, ObjectId> {

    User findByUsername(String username);
}
