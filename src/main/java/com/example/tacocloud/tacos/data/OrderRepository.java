package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.TacoOrder;
import com.example.tacocloud.tacos.security.User;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marat
 */
@Repository
public interface OrderRepository extends MongoRepository<TacoOrder, ObjectId> {

    List<TacoOrder> findByUserOrderByPlacedAtDesc(Example<User> example, Pageable pageable);

}
