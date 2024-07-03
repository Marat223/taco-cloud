package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.Ingredient;
import com.example.tacocloud.tacos.model.Ingredient.Type;
import com.example.tacocloud.tacos.security.User;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
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

    @Bean
    public CommandLineRunner dataLoader() {
        return args -> {
//            userRepository.save(new User(new ObjectId("fe0f0ef0efe0f0ef0ef0ef0e"), "bob", passwordEncoder.encode("password"), "bob1", "zakharova", "minsk", "be", "220088", "1234", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//            userRepository.save(new User(new ObjectId("fe1f0ef0efe0f0ef0ef0ef0e"), "joe", passwordEncoder.encode("password"), "joe1", "zakharova", "minsk", "be", "220088", "1234", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));

            ingredientRepo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            ingredientRepo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            ingredientRepo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            ingredientRepo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            ingredientRepo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            ingredientRepo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            ingredientRepo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            ingredientRepo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            ingredientRepo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            ingredientRepo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        };
    }
}
