package pro.sky.java.course.expenses.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course.expenses.entity.Expense;
import pro.sky.java.course.expenses.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {
    public ExpensesController(ExpenseService expenseService, ExpenseService expenseService1) {
        this.expenseService = expenseService1;
    }
    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getALlExpenses(RequestParam("page") Integer pageNumber, @RequestParam("size") Integer pageSize) {
        List<Expense> expenses = expenseService.getAllExpenses(pageNumber, pageSize);
        return ResponseEntity.ok(expenses);
    }

    @PostMapping
    public ResponseEntity<Void> createExpense(@RequestBody Expense expense) {
        expenseService.createExpense(expense);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable("id") Integer id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok(null);
    }
}
