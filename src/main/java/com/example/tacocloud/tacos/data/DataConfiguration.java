package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.Ingredient;
import com.example.tacocloud.tacos.model.Ingredient.Type;
import com.example.tacocloud.tacos.model.Taco;
import com.example.tacocloud.tacos.security.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

/**
 * @author marat
 */
@Configuration
@Slf4j
@EnableMongoRepositories(basePackages = {"com.example.tacocloud.tacos.data"})
public class DataConfiguration {

    @Autowired
    private IngredientRepository ingredientRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    TacoRepository tacoRepo;

    @Bean
    public CommandLineRunner dataLoader() {
        return args -> {
            if (userRepository.findAll().isEmpty()) {
                userRepository.save(new User(new ObjectId("fe0f0ef0efe0f0ef0ef0ef0e"), "bob", passwordEncoder.encode("password"), "bob1", "zakharova", "minsk", "be", "220088", "1234", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
                userRepository.save(new User(new ObjectId("fe1f0ef0efe0f0ef0ef0ef0e"), "joe", passwordEncoder.encode("password"), "joe1", "zakharova", "minsk", "be", "220088", "1234", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
            }

            Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
            Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
            Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
            Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
            Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
            Ingredient lettuce = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
            Ingredient cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
            Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
            Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
            Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);
            ingredientRepo.save(flourTortilla);
            ingredientRepo.save(cornTortilla);
            ingredientRepo.save(groundBeef);
            ingredientRepo.save(carnitas);
            ingredientRepo.save(tomatoes);
            ingredientRepo.save(lettuce);
            ingredientRepo.save(cheddar);
            ingredientRepo.save(jack);
            ingredientRepo.save(salsa);
            ingredientRepo.save(sourCream);

            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(Arrays.asList(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
            tacoRepo.save(taco1);
            Taco taco2 = new Taco();
            taco2.setName("Bovine Bounty");
            taco2.setIngredients(Arrays.asList(cornTortilla, groundBeef, cheddar, jack, sourCream));
            tacoRepo.save(taco2);
            Taco taco3 = new Taco();
            taco3.setName("Veg-Out");
            taco3.setIngredients(Arrays.asList(flourTortilla, cornTortilla, tomatoes, lettuce, salsa));
            tacoRepo.save(taco3);
        };
    }
}
