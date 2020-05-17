package sbnz.integracija.facts;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MealHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;
	
//	private Recipe meal;
//	private Ingredient snack; //TODO
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
}
