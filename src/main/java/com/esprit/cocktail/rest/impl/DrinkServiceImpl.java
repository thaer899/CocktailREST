package com.esprit.cocktail.rest.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;




import com.esprit.cocktail.rest.entities.Category;
import com.esprit.cocktail.rest.entities.Drink;
import com.esprit.cocktail.rest.entities.Ingredient;
import com.esprit.cocktail.rest.entities.Vote;
import com.esprit.cocktail.rest.interfaces.DrinkService;

/**
 * Session Bean implementation class DrinkService
 */
@Stateless
public class DrinkServiceImpl implements DrinkService , Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 2959679908653449716L;
	@PersistenceContext(unitName="cocktail")
	 EntityManager entityManager;

	
   
   
	@Override
	public Drink getDrinkById(int id) {
		return entityManager.find(Drink.class, id);
	}

	@Override
	public Drink getDrinkByName(String name) {
		TypedQuery<Drink> query = (TypedQuery<Drink>) entityManager.createNamedQuery("getDrinkByName", Drink.class);
		query.setParameter("name", name);
		
		return query.getSingleResult();
	}

	@Override
	public List<Drink> getAllDrinks() {
		Query query=entityManager.createQuery("SELECT u FROM Drink u");
		
		return query.getResultList();
	}

	@Override
	public List<Drink> getDrinksByCategory(int id) {
		Query query=entityManager.createQuery("SELECT u FROM Drink u WHERE u.category.id=:id");
		query.setParameter("id", id);
		return query.getResultList();
	}

//	@Override
//	public List<Drink> getDrinksByIngredients(List<Ingredient> ings) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public List<Drink> getDrinksByIngredients(List<Ingredient> ings) {
//
//		List<Drink> ds = null;
//		
//		for(Drink drink : drinks)
//		{
//			drink.getIngredients().containsAll(ings);
//			ds.add(drink);
//		}
//		
//		return ds;
//		
//	}

	@Override
	public Response addDrink(Drink drink) {
		entityManager.persist(drink);
		return Response.status(Status.OK).entity("drink added").build();
	}


	@Override
	public Response addDrink(String name,String description) {
		Drink drink = new Drink();
		drink.setName(name);
		drink.setDescription(description);
		entityManager.persist(drink);
		return Response.status(Status.OK).entity("drink added").build();
	}


	@Override
	public Response removeDrink(int id) {
		Drink drink = new Drink();
		drink.setId(id);
		entityManager.remove(entityManager.merge(drink));
		return Response.status(200).entity("drink removed").build();
	
	}

	@Override
	public Response ratingDrink(int id) {
		List<Vote> votes =  entityManager
				.createQuery("SELECT u FROM Vote u WHERE u.drink.id=:id")
				.setParameter("id", id)
				.getResultList();
		int count = votes.size();
		int tot = 0;
		for( Vote v : votes){
			tot = tot + v.getValue();
		}
		float rate = tot/count;
		
		
		return Response.status(Status.OK).entity(rate).build();
	}

}
