package expense_analyser.ui;

import java.util.List;
import java.util.Scanner;

import expense_analyser.model.Expense;
import expense_analyser.services.ExpenseTracker;

public class MenuUI {
	Scanner sc = new Scanner(System.in);
	boolean flag = true;
	ExpenseTracker service = new ExpenseTracker();

	public void start() {

		System.out.println("=======================================");
		System.out.println("Personal Expense Analyser");
		System.out.println("Track, analyse and control expenses");
		System.out.println("=======================================");
		do {
			showMenu();
		} while (flag);
	}

	public void showMenu() {
		System.out.println("\n=======================================");
		System.out.println("Please Choose an option below : ");
		System.out.println("1. Add Expense");
		System.out.println("2. View Expense Summary");
		System.out.println("3. Filter based Category");
		System.out.println("4. Exit");
		System.out.println("=======================================");
		System.out.println("Enter the your choice : ");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			handleAddExpense();
			break;
		case 2:
			handleViewSummary();
			break;
		case 3:
			filterBasedOnCategory();
			break;
		case 4:
			handleExit();
			System.out.println("\nThanks for using our service.");
			break;
		default:
			System.out.println("Invalid option,try again");

		}

	}

	public void handleExit() {
		flag = false;
	}

	public void handleAddExpense() {
		System.out.println("Select category of Expense : ");
		System.out.println("1. Food");
		System.out.println("2. Travel");
		System.out.println("3. Education");
		System.out.println("4. Entertainment");
		System.out.println("5. Shopping");
		System.out.println("6. Health");
		System.out.println("7. Others");

		System.out.print("Enter category number: ");
		int categoryChoice = sc.nextInt();
		sc.nextLine();

		String category;
		switch (categoryChoice) {
		case 1:
			category = "Food";
			break;
		case 2:
			category = "Travel";
			break;
		case 3:
			category = "Education";
			break;
		case 4:
			category = "Entertainment";
			break;
		case 5:
			category = "Shopping";
			break;
		case 6:
			category = "Health";
			break;
		case 7:
			category = "Others";
			break;
		default:
			System.out.println("Invalid category. Defaulting to Others.");
			category = "Others";
		}

		System.out.print("Enter amount: ");
		double amount = sc.nextDouble();
		sc.nextLine();

		System.out.print("Enter description: ");
		String description = sc.nextLine();

		service.addExpense(category, amount, description);

		System.out.println("Expense recorded successfully.");
	}

	public void handleViewSummary() {
		List<Expense> expenses = service.getAllExpenses();
		if (expenses.isEmpty()) {
			System.out.println("No expenses found.");
			return;
		}

		double total = 0;

		System.out.println("=======================================");
		System.out.println("ID | Category | Amount | Description");
		System.out.println("=======================================");

		for (Expense e : expenses) {
			System.out
					.println(e.getId() + " | " + e.getCategory() + " | ₹" + e.getAmount() + " | " + e.getDescription());
			total += e.getAmount();
		}

		System.out.println("=======================================");
		System.out.println("Total Expense: ₹" + total);
	}

	public void filterBasedOnCategory() {

		System.out.println("Select category to filter Expense : ");
		System.out.println("1. Food");
		System.out.println("2. Travel");
		System.out.println("3. Education");
		System.out.println("4. Entertainment");
		System.out.println("5. Shopping");
		System.out.println("6. Health");
		System.out.println("7. Others");

		System.out.print("Enter category number: ");
		int categoryChoice = sc.nextInt();
		sc.nextLine();

		String category;
		switch (categoryChoice) {
		case 1:
			category = "Food";
			break;
		case 2:
			category = "Travel";
			break;
		case 3:
			category = "Education";
			break;
		case 4:
			category = "Entertainment";
			break;
		case 5:
			category = "Shopping";
			break;
		case 6:
			category = "Health";
			break;
		case 7:
			category = "Others";
			break;
		default:
			System.out.println("Invalid category. Defaulting to Others.");
			category = "Others";
		}
		List<Expense> expenses = service.getExpensesByCategory(category);

		for (Expense e : expenses) {
			System.out.println(e.getCategory() + " | ₹" + e.getAmount());
		}
		System.out.println("Category " + category + " Total : " + service.categoryTotal(expenses, category));
		System.out.println("Total " + service.totalExpense(service.getAllExpenses()));

	}

}
