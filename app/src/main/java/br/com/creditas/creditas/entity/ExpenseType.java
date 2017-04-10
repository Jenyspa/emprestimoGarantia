package br.com.creditas.creditas.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by renan on 09/04/17.
 */

public class ExpenseType {
    private int color;
    private String label;

    public ExpenseType(int color, String label) {
        this.color = color;
        this.label = label;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getColor() {
        return color;
    }

    public String getLabel() {
        return label;
    }

    public static List<ExpenseType> getAll(){
        return Arrays.asList(
                new ExpenseType(android.R.color.holo_blue_dark, "Compras"),
                new ExpenseType(android.R.color.holo_green_dark, "Outros"),
                new ExpenseType(android.R.color.holo_red_dark, "Lazer"),
                new ExpenseType(android.R.color.holo_orange_dark, "Alimentação")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseType that = (ExpenseType) o;

        return color == that.color;

    }

    @Override
    public int hashCode() {
        return color;
    }
}
