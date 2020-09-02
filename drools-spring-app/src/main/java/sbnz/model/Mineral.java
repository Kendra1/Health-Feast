package sbnz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mineral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double iron;
	private double calcium;
	private double potassium;
	private double magnesium;
	private double zinc;
	private double sodium;
	private double copper;
	
	public Mineral(double iron, double calcium, double potassium, double magnesium, double zinc, double sodium,
			double copper) {
		this.iron = iron;
		this.calcium = calcium;
		this.potassium = potassium;
		this.magnesium = magnesium;
		this.zinc = zinc;
		this.sodium = sodium;
		this.copper = copper;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getIron() {
		return iron;
	}


	public void setIron(double iron) {
		this.iron = iron;
	}


	public double getCalcium() {
		return calcium;
	}


	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}


	public double getPotassium() {
		return potassium;
	}


	public void setPotassium(double potassium) {
		this.potassium = potassium;
	}


	public double getMagnesium() {
		return magnesium;
	}


	public void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}


	public double getZinc() {
		return zinc;
	}


	public void setZinc(double zinc) {
		this.zinc = zinc;
	}


	public double getSodium() {
		return sodium;
	}


	public void setSodium(double sodium) {
		this.sodium = sodium;
	}


	public double getCopper() {
		return copper;
	}


	public void setCopper(double copper) {
		this.copper = copper;
	}
}
