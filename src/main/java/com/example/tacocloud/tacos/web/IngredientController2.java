package com.example.tacocloud.tacos.web;

import com.example.tacocloud.tacos.model.Ingredient;
import com.example.tacocloud.tacos.rest.InternalRestClient;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/V2/ingredients", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class IngredientController2 {

    @Autowired
    private InternalRestClient restClient;

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable("id") String id) {

        return restClient.getIngredientById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateIngredient(@PathVariable("id") String id, @NonNull @RequestBody Ingredient ingredient) {

        ingredient.setId(id);
        restClient.updateIngredient(ingredient);
    }
}
