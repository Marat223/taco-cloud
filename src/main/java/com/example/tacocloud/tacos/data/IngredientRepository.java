package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marat
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
