package com.esprit.cocktail.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rating
 *
 */
@Entity

public class Rating implements Serializable {

	   
	@Id
	private int id;
	private float rate;
	private int drink;
	private static final long serialVersionUID = 1L;

	public Rating() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public float getRate() {
		return this.rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}   
	public int getDrink() {
		return this.drink;
	}

	public void setDrink(int drink) {
		this.drink = drink;
	}
   
}
