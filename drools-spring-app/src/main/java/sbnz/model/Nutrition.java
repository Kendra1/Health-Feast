package sbnz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nutrition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double fat;
	private double saturatedFat;
	private double cholesterol;
	private double sodium;
	private double complexCarbs;
	private double sugars;
	private double protein;
	
	public Nutrition() {}
	
	public Nutrition(double fat, double saturatedFat, double cholesterol, double sodium, double complexCarbs,
			double sugars, double protein) {
		this.fat = fat;
		this.saturatedFat = saturatedFat;
		this.cholesterol = cholesterol;
		this.sodium = sodium;
		this.complexCarbs = complexCarbs;
		this.sugars = sugars;
		this.protein = protein;
	}
	
	public double getTransFat() {
		return fat;
	}
	public void setTransFat(double transFat) {
		this.fat = transFat;
	}
	public double getSaturatedFat() {
		return saturatedFat;
	}
	public void setSaturatedFat(double saturatedFat) {
		this.saturatedFat = saturatedFat;
	}
	public double getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}
	public double getSodium() {
		return sodium;
	}
	public void setSodium(double sodium) {
		this.sodium = sodium;
	}
	public double getComplexCarbs() {
		return complexCarbs;
	}
	public void setComplexCarbs(double complexCarbs) {
		this.complexCarbs = complexCarbs;
	}
	public double getSugars() {
		return sugars;
	}
	public void setSugars(double sugars) {
		this.sugars = sugars;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
}
