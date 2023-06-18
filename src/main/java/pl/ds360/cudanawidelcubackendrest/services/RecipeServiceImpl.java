package pl.ds360.cudanawidelcubackendrest.services;

import pl.ds360.cudanawidelcubackendrest.entities.Category;
import pl.ds360.cudanawidelcubackendrest.entities.Recipe;
import pl.ds360.cudanawidelcubackendrest.exceptions.RecipeNotFoundException;
import pl.ds360.cudanawidelcubackendrest.interfaces.FileService;
import pl.ds360.cudanawidelcubackendrest.interfaces.RecipeRepository;
import pl.ds360.cudanawidelcubackendrest.interfaces.RecipeService;
import pl.ds360.cudanawidelcubackendrest.repositories.RecipeRepositoryImpl;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class RecipeServiceImpl implements RecipeService {
    RecipeRepository recipeRepository;

    @PostConstruct
    private void init() {
        recipeRepository = new RecipeRepositoryImpl();
        recipeRepository.init();
    }

    @Override
    public ArrayList<Recipe> getRecipes() {
        return recipeRepository.getRecipes();
    }

    @Override
    public String getRecipesToString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Recipe recipe: recipeRepository.getRecipes()) {
            stringBuilder.append(recipe.getName()).append(";");
        }

        return stringBuilder.toString();
    }

    @Override
    public Recipe getRecipe(int id) throws RecipeNotFoundException {
        Recipe recipe = recipeRepository.getRecipe(id);
        return (recipe != null) ? recipe : new Recipe();
    }

    @Override
    public Recipe getRecipeByName(String name) {
        Recipe recipe = recipeRepository.getRecipe(name);
        return (recipe != null) ? recipe : new Recipe();
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeRepository.addRecipe(recipe);
    }

    @Override
    public void modifyRecipe(Recipe recipe) {
        recipeRepository.modifyRecipe(recipe);
    }

    @Override
    public void deleteRecipe(int id) {
        recipeRepository.deleteRecipe(id);
    }

    @Override
    public void deleteRecipeByName(String name) {
        recipeRepository.deleteRecipe(name);
    }

    @Override
    public void rateRecipe(int id, int vote) throws RecipeNotFoundException {
        Recipe recipe = recipeRepository.getRecipe(id);
        int countVotes = recipe.getCountVotes() + 1;
        recipe.setCountVotes(countVotes);

        recipe.addVote(vote);

        Double newRating = 0.0;
        for(Integer integer: recipe.getVotes()) {
            newRating += integer;
        }
        newRating = newRating / countVotes;

        recipe.setRating(newRating);
    }

    @Override
    public void rateRecipeByName(String name, int vote) {
        Recipe recipe = recipeRepository.getRecipe(name);
        int countVotes = recipe.getCountVotes() + 1;
        recipe.setCountVotes(countVotes);

        recipe.addVote(vote);

        Double newRating = 0.0;
        for(Integer integer: recipe.getVotes()) {
            newRating += integer;
        }
        newRating = newRating / countVotes;

        recipe.setRating(newRating);
    }

    @Override
    public List<Recipe> getRecipesByCategory(Category category) {

        List<Recipe> recipesByCategory = recipeRepository.getRecipes()
                .stream()
                .filter(r -> r.getCategory().equals(category))
                .collect(Collectors.toList());

        return recipesByCategory;
    }
}
