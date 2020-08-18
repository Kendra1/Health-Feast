package sbnz.model.drools;

public class PrioritizedRecipe {

	private String name;
	private int priority;
	
	public PrioritizedRecipe(String name, Number foundIngridients, int ingridients) {
		this.name = name;
		this.priority = ingridients / (int) foundIngridients;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
}
