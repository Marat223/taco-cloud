package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.Ingredient;
import java.util.Optional;

/**
 *
 * @author marat
 */
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
