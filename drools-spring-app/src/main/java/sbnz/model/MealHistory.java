package sbnz.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MealHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	
	//this can be one/more ingredient/recipe
	@OneToMany
	private List<IngredientQuantity> meals;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public MealHistory() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<IngredientQuantity> getMeals() {
		return meals;
	}

	public void setMeals(List<IngredientQuantity> meals) {
		this.meals = meals;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
