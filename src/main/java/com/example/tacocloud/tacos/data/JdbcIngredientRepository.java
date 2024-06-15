package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.Ingredient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marat
 */
@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {

        List<Ingredient> result = jdbcTemplate.query("select id, name, type from INgredient where id=?", this::mapRowToIngredient, id);
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public Ingredient save(final Ingredient ingredient) {

        jdbcTemplate.update("insert into Ingredient(id, name, type) values (?,?,?)", ingredient.getId(), ingredient.getName(), ingredient.getType().toString());

        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(row.getString("id"), row.getString("name"), Ingredient.Type.valueOf(row.getString("type")));
    }
}
