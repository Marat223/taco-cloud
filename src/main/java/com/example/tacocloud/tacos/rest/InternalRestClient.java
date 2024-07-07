package com.example.tacocloud.tacos.rest;

import com.example.tacocloud.tacos.model.Ingredient;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Component
@Slf4j
public class InternalRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public Ingredient getIngredientById(String ingredientId) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/data-api/ingredients/{ingredientId}").build(Map.of("ingredientId", ingredientId));
        ResponseEntity<Ingredient> entity = restTemplate.getForEntity(url, Ingredient.class);

        log.info("Статус ответа: {}", entity.getStatusCode().value());
        log.info("Время ответа: {}", entity.getHeaders().getDate());

        return entity.getBody();
    }

    public void updateIngredient(@NonNull Ingredient ingredient) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/data-api/ingredients/{ingredientId}").build(Map.of("ingredientId", ingredient.getId()));

        restTemplate.put(url, ingredient);
    }

    public void deleteIngredient(@NonNull Ingredient ingredient) {

        restTemplate.delete(UriComponentsBuilder.fromHttpUrl("http://localhost:8080/data-api/ingredients/{ingredientId}").build(Map.of("ingredientId", ingredient.getId())));
    }

    public Ingredient createIngredient(Ingredient ingredient) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/data-api/ingredients").build().toUri();
        ResponseEntity<Ingredient> entity = restTemplate.postForEntity(url, ingredient, Ingredient.class);

        log.info("Статус ответа:  {}", entity.getStatusCode().value());
        log.info("Расположение нового ресурса: {}", entity.getHeaders().getLocation());

        return entity.getBody();
    }
}
