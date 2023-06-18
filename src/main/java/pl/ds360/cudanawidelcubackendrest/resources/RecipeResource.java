package pl.ds360.cudanawidelcubackendrest.resources;

import pl.ds360.cudanawidelcubackendrest.dtos.RateRecipeByNameDto;
import pl.ds360.cudanawidelcubackendrest.dtos.RateRecipeDto;
import pl.ds360.cudanawidelcubackendrest.entities.Category;
import pl.ds360.cudanawidelcubackendrest.entities.Recipe;
import pl.ds360.cudanawidelcubackendrest.exceptions.RecipeNotFoundException;
import pl.ds360.cudanawidelcubackendrest.interfaces.FileService;
import pl.ds360.cudanawidelcubackendrest.interfaces.RecipeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("/recipe")
public class RecipeResource {

    @Inject
    RecipeService recipeService;

    @Inject
    FileService fileService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Recipe> getRecipes(@Context UriInfo uriInfo) {

        return recipeService.getRecipes();
    }

    @GET
    @Path("/string")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRecipesToString() {
        return recipeService.getRecipesToString();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe getRecipe(@PathParam("id") int id) throws RecipeNotFoundException {
        Recipe recipe = recipeService.getRecipe(id);
        return recipe;
    }

    @GET
    @Path("/byname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe getRecipeByName(@PathParam("name") String name) {
        Recipe recipe = recipeService.getRecipeByName(name);
        return recipe;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addRecipe(Recipe recipe, @Context UriInfo uriInfo) throws URISyntaxException {
        String uri = uriInfo.getBaseUriBuilder()
                .path(RecipeResource.class)
                .path("image")
                .path(recipe.getName())
                .build()
                .toString();

        recipe.addLink(uri, "image");
        recipeService.addRecipe(recipe);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void modifyRecipe(Recipe recipe) {
        recipeService.modifyRecipe(recipe);
    }

    @DELETE
    @Path("/{id}")
    public void deleteRecipe(@PathParam("id") int id) {
        recipeService.deleteRecipe(id);
    }

    @DELETE
    @Path("/byname/{id}")
    public void deleteRecipeByName(@PathParam("id") String name) {
        recipeService.deleteRecipeByName(name);
    }

    @POST
    @Path("/rate")
    @Consumes(MediaType.APPLICATION_JSON)
    public void rateRecipe(RateRecipeDto dto) throws RecipeNotFoundException {
        recipeService.rateRecipe(dto.getId(), dto.getVote());
    }

    @POST
    @Path("/ratebyname")
    @Consumes(MediaType.APPLICATION_JSON)
    public void rateRecipeByName(RateRecipeByNameDto dto) {
        recipeService.rateRecipeByName(dto.getName(), dto.getVote());
    }

    @GET
    @Path("/bycategory/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> getRecipesByCategory(@PathParam("category") int id) {
        Category category = Category.values()[id];
        return recipeService.getRecipesByCategory(category);
    }

    @GET
    @Produces("image/jpeg")
    @Path("image/{name}")
    public byte[] getImage(@PathParam("name") String name) {
        return fileService.downloadImage(name);
    }

    @GET
    @Produces("application/pdf")
    @Path("pdf")
    public byte[] getImage(@QueryParam("name") String name, @QueryParam("products") String products) throws IOException {
        return fileService.downloadRecipeProductsPdf(name, products);
    }
}