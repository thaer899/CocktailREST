package com.esprit.cocktail.rest.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@Entity
@Table(name="category")
public class Category implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4013488261892089299L;
	int id;
	String label;
	String imgPath;
	
	
	@JsonIgnore
	List<Drink> drinks ;
	
	public Category() {
		super();
	}
	
	
	public Category(int id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}


	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	
	
	@JsonIgnore
	@OneToMany(/*fetch=FetchType.EAGER,*/mappedBy="category")
	public List<Drink> getDrinks() {
		return drinks;
	}

	@JsonProperty
	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}
	
	

}
