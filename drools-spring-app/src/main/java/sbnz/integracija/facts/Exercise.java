package sbnz.integracija.facts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String muscle;
	
	public Exercise(){}
	
	public Exercise(String name, String muscle) {
		this.name = name;
		this.muscle = muscle;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMuscle() {
		return muscle;
	}
	public void setMuscle(String muscle) {
		this.muscle = muscle;
	}
}
