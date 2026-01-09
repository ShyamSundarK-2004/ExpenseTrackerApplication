package expense_analyser.model;

public class Expense {

	private int id;
	private String category;
	private double amount;
	private String description;

	public Expense(String category, double amount, String description) {
		this.category = category;
		this.amount = amount;
		this.description = description;
	}

	public Expense(int id, String category, double amount, String description) {
		this.id = id;
		this.category = category;
		this.amount = amount;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", category=" + category + ", amount=" + amount + ", description=" + description
				+ "]";
	}

}
