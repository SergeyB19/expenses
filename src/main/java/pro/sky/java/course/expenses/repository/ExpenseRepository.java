package pro.sky.java.course.expenses.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.sky.java.course.expenses.entity.Expense;
import org.springframework.data.jpa.repository.JPARepository;
import pro.sky.java.course.expenses.entity.ExpenseByCategory;

import java.util.List;

@Repository
public interface ExpenseRepository extends JPARepository<Expense, Integer>{
@Query(value = "SELECT category, SUM (amount) as amount FROM expenses GROUP BY category", nativeQuery = true)
List<ExpenseByCategory> getExpensesByCategory();
}
