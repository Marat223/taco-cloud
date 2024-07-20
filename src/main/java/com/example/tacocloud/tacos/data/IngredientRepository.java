package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marat
 */
@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {

}
