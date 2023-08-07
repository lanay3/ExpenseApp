package com.example.expenseapp;

public abstract class Transaction {
    private String name;
    private int id;
    private TransactionType type;
    private double amount;
    private Category category;

    private String date;

    public Transaction(int id, String name,  double amount, String date, Category category, TransactionType type) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.id ++;
    }

    public Transaction() {
        this(0, "", 0, "", null, TransactionType.EXPENSE);
        this.id ++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionType getType() {
        return type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void doTransact(double amt) {
        this.amount += amt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //public abstract String getExtra();
}
