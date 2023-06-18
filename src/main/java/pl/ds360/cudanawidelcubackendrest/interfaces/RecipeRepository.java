package pl.ds360.cudanawidelcubackendrest.interfaces;

import pl.ds360.cudanawidelcubackendrest.entities.Recipe;
import pl.ds360.cudanawidelcubackendrest.exceptions.RecipeNotFoundException;

import java.util.ArrayList;

public interface RecipeRepository {
    void init();
    void addRecipe(Recipe recipe);
    void modifyRecipe(Recipe recipe);
    void deleteRecipe(int id);
    void deleteRecipe(String name);
    Recipe getRecipe(int id) throws RecipeNotFoundException;
    Recipe getRecipe(String name);
    ArrayList<Recipe> getRecipes();
}
