package pl.ds360.cudanawidelcubackendrest.interfaces;

import pl.ds360.cudanawidelcubackendrest.entities.Category;
import pl.ds360.cudanawidelcubackendrest.entities.Recipe;
import pl.ds360.cudanawidelcubackendrest.exceptions.RecipeNotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface RecipeService {
    ArrayList<Recipe> getRecipes();

    String getRecipesToString();

    Recipe getRecipe(int id) throws RecipeNotFoundException;

    Recipe getRecipeByName(String name);

    void addRecipe(Recipe recipe);

    void modifyRecipe(Recipe recipe);

    void deleteRecipe(int id);

    void deleteRecipeByName(String name);

    void rateRecipe(int id, int vote) throws RecipeNotFoundException;

    void rateRecipeByName(String name, int vote);

    List<Recipe> getRecipesByCategory(Category category);
}