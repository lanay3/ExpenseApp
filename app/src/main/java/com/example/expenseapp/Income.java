package com.example.expenseapp;

public class Income extends Transaction {
    //private IncomeCategory income;

    public Income(int id, String name,  double amount, String date, Category category, TransactionType type) {
        super(id, name, amount, date, category, type);
        //this.income = income;
    }

//    public IncomeCategory getIncome() {
//        return income;
//    }
//
//    public void setIncome(IncomeCategory income) {
//        this.income = income;
//    }

//    public String getExtra() {
//        return String.valueOf(income);
//    }
}
