package expense_analyser.rule;

public class ExpenseRuleEngine {

	private static final double MONTH_LIMIT = 50000;
	private static final double FOOD_LIMIT = 850;

	public void checklimit(String category, double amount, double currentTotal, double categoryTotal) {

		double newTotal = currentTotal + amount;
		double newCategoryTotal = categoryTotal + amount;

		if (newTotal > MONTH_LIMIT) {
			System.out.println("⚠ Warning: Monthly budget exceeded!");
		}

		if (category.equalsIgnoreCase("Food") && newCategoryTotal > FOOD_LIMIT) {
			System.out.println("⚠ Warning: Food expense is high this month!");
		}
	}
}
