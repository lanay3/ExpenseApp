package com.example.expenseapp;

public abstract class Transaction {
    private String name;
    private int id;
    private TransactionType type;
    private double amount;

    public Transaction(String name, int id, TransactionType type, double amount) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.id ++;
    }

    public Transaction() {
        this("", 0, TransactionType.EXPENSE, 0);
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
}
