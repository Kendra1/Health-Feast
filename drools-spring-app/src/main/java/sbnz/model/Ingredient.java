package sbnz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private double price;
	
	private double calories;
	
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;
	
	@OneToOne
	@JoinColumn(name = "nutrition_id")
	private Nutrition nutritionTable;
	
	@OneToOne
	@JoinColumn(name = "vitamin_id")
	private Vitamin vitaminTable;
	
	@OneToOne
	@JoinColumn(name = "mineral_id")
	private Mineral mineralTable;
	
	//e.g. undercooked egg can lead to salmonella
	private String warning;
	
	private String unit;
	
	public Ingredient() {}

	public Ingredient(Long id, String name, double price, Nutrition nutritionTable,
			Vitamin vitaminTable, Mineral mineralTable, String warning, Sale sale) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.nutritionTable = nutritionTable;
		this.vitaminTable = vitaminTable;
		this.mineralTable = mineralTable;
		this.warning = warning;
		this.sale = sale;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Nutrition getNutritionTable() {
		return nutritionTable;
	}

	public void setNutritionTable(Nutrition nutritionTable) {
		this.nutritionTable = nutritionTable;
	}

	public Vitamin getVitaminTable() {
		return vitaminTable;
	}

	public void setVitaminTable(Vitamin vitaminTable) {
		this.vitaminTable = vitaminTable;
	}

	public Mineral getMineralTable() {
		return mineralTable;
	}

	public void setMineralTable(Mineral mineralTable) {
		this.mineralTable = mineralTable;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}
	
}
