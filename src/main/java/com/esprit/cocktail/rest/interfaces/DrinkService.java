package com.esprit.cocktail.rest.interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.esprit.cocktail.rest.entities.Drink;
import com.esprit.cocktail.rest.entities.Ingredient;

@Local
@Path("cocktail")
public interface DrinkService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Drink> getAllDrinks();
	
	@GET
	@Path("drink/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	Drink getDrinkById(@PathParam("id")int id);
	
	@GET
	@Path("name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	Drink getDrinkByName(@PathParam("name")String name);
	 
	
	
	@GET
	@Path("/category/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Drink> getDrinksByCategory(@PathParam("id")int id);
	
//	@GET
//	@Path("drink/{ings}")
//	@Produces(MediaType.APPLICATION_JSON)
//	List<Drink> getDrinksByIngredients(@PathParam("ings")List<Ingredient> ings);
//	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	Response addDrink(Drink drink);

	@POST
	@Path("{name}/{desc}")
	Response addDrink(@PathParam("name") String name,
			@PathParam("desc") String description);

	@DELETE
	@Path("{id:[0-9][0-9]*}")
	Response removeDrink(@PathParam("id") int id);
	
	@GET
	@Path("rate/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	Response ratingDrink(@PathParam("id") int id);
	
}
