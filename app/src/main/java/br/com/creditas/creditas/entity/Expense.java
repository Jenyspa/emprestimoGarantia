package br.com.creditas.creditas.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by renan on 09/04/17.
 */

public class Expense {
    private ExpenseType type;
    private String title;
    private BigDecimal value;

    private static List<Expense> expenses = new ArrayList<>();

    public Expense(ExpenseType type, String title, BigDecimal value) {
        this.type = type;
        this.title = title;
        this.value = value;
    }

    public ExpenseType getExpenseType() {
        return type;
    }

    public void setExpenseType(ExpenseType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public static List<Expense> getSavedExpenses(){
        return expenses;
    }

    public static Map<ExpenseType, Integer> getExpensesAmountByType(){
        Map map = new HashMap<ExpenseType, Integer>();
        int amountCompras = 0;
        int amountLazer = 0;
        int amountOutros = 0;
        int amountAlimentacao = 0;

            for (Expense expense : Expense.getSavedExpenses()){

                if (expense.getExpenseType().getColor() == ExpenseType.getAll().get(0).getColor()) amountCompras++;
                if (expense.getExpenseType().getColor() == ExpenseType.getAll().get(1).getColor()) amountOutros++;
                if (expense.getExpenseType().getColor() == ExpenseType.getAll().get(2).getColor()) amountLazer++;
                if (expense.getExpenseType().getColor() == ExpenseType.getAll().get(3).getColor()) amountAlimentacao++;


            }

        if (Expense.getSavedExpenses().isEmpty()){
            map.put(ExpenseType.getAll().get(0), 0);
            map.put(ExpenseType.getAll().get(1), 0);
            map.put(ExpenseType.getAll().get(2), 0);
            map.put(ExpenseType.getAll().get(3), 0);

        } else {
            map.put(ExpenseType.getAll().get(0), (amountCompras * 100) / Expense.getSavedExpenses().size());
            map.put(ExpenseType.getAll().get(1), (amountOutros * 100) / Expense.getSavedExpenses().size());
            map.put(ExpenseType.getAll().get(2), (amountLazer * 100) / Expense.getSavedExpenses().size());
            map.put(ExpenseType.getAll().get(3), (amountAlimentacao * 100) / Expense.getSavedExpenses().size());

        }
        return map;
    }

    public static BigDecimal getSavedExpenesAmount(){
        BigDecimal total = BigDecimal.ZERO;
        for (Expense expense : getSavedExpenses()){
            total = total.add(expense.value);
        }
        return total.setScale(2, BigDecimal.ROUND_DOWN);

    }
}
