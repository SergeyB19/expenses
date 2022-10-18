package pro.sky.java.course.expenses.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pro.sky.java.course.expenses.ExpensesApplication;
import pro.sky.java.course.expenses.entity.Expense;
import pro.sky.java.course.expenses.entity.ExpenseByCategory;
import pro.sky.java.course.expenses.repository.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1., pageSize);
        return expenseRepository.findAll(pageRequest).getContent();
    }

    public void createExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }

    public List<ExpenseByCategory> getExpensesByCategory() {
         return expenseRepository.getExpensesByCategory();
    }
}
