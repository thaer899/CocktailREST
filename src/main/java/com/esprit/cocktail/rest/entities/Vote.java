package com.esprit.cocktail.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vote
 *
 */
@Entity

public class Vote implements Serializable {

	   
	
	private int id;
	private int value;
	private Drink drink;
	private static final long serialVersionUID = 1L;

	public Vote() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@ManyToOne
	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}   
	
   
}
