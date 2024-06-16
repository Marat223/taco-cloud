package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marat
 */
@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}
