package expense_analyser.services;

import java.util.List;

import expense_analyser.dao.ExpenseDAO;
import expense_analyser.model.Expense;
import expense_analyser.rule.ExpenseRuleEngine;

public class ExpenseTracker {

	private ExpenseDAO expenseDAO = new ExpenseDAO();
	private ExpenseRuleEngine ruleEngine = new ExpenseRuleEngine();

	public void addExpense(String category, double amount, String description) {

		List<Expense> expenses = expenseDAO.viewSummary();

		double total = totalExpense(expenses);
		double categoryTotal = categoryTotal(expenses, category);

		ruleEngine.checklimit(category, amount, total, categoryTotal);

		Expense newExpense = new Expense(category, amount, description);
		expenseDAO.addExpense(newExpense);
	}

	public double totalExpense(List<Expense> expenses) {
		double total = 0;
		for (Expense e : expenses) {
			total += e.getAmount();
		}
		return total;
	}

	public double categoryTotal(List<Expense> expenses, String category) {
		double total = 0;
		for (Expense e : expenses) {
			if (e.getCategory().equalsIgnoreCase(category)) {
				total += e.getAmount();
			}
		}
		return total;
	}

	public List<Expense> getAllExpenses() {
		return expenseDAO.viewSummary();
	}

	public List<Expense> getExpensesByCategory(String category) {
		return expenseDAO.getExpensesByCategory(category);
	}

}
