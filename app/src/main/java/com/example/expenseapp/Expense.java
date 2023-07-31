package com.example.expenseapp;

public class Expense extends Transaction{
    private ExpenseCategory category;

    public Expense(String name, int id, TransactionType type, double amount, ExpenseCategory category) {
        super(name, id, type, amount);
        this.category = category;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }


}
