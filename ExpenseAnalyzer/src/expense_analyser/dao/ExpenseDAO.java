package expense_analyser.dao;

import expense_analyser.db.DBConnection;
import expense_analyser.model.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

	public boolean addExpense(Expense expense) {
		String sql = "INSERT INTO expenses (category, amount, description) VALUES (?, ?, ?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, expense.getCategory());
			ps.setDouble(2, expense.getAmount());
			ps.setString(3, expense.getDescription());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Expense> viewSummary() {
		List<Expense> expenses = new ArrayList<>();
		String sql = " SELECT * FROM expenses";

		try (Connection con = DBConnection.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Expense expense = new Expense(rs.getInt("id"), rs.getString("category"), rs.getDouble("amount"),
						rs.getString("description"));
				expenses.add(expense);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return expenses;
		}
		return expenses;
	}

	public List<Expense> getExpensesByCategory(String category) {
		List<Expense> expenses = new ArrayList<>();
		String sql = "SELECT * FROM expenses  WHERE category = ? ORDER BY id DESC";

		try (Connection con = DBConnection.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Expense expense = new Expense(rs.getInt("id"), rs.getString("category"), rs.getDouble("amount"),
						rs.getString("description"));
				expenses.add(expense);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return expenses;
		}
		return expenses;
	}
}
