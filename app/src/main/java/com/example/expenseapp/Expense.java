package com.example.expenseapp;

public class Expense extends Transaction{
    //private ExpenseCategory expense;

    public Expense(int id, String name,  double amount, String date, Category category, TransactionType type) {
        super(id, name, amount, date, category, type);
        //this.expense = expense;
    }

//    public ExpenseCategory getCategory() {
//        return expense;
//    }
//
//    public void setCategory(ExpenseCategory expense) {
//        this.expense = expense;
//    }
//
//    public String getExtra() {
//        return String.valueOf(expense);
//    }
}
