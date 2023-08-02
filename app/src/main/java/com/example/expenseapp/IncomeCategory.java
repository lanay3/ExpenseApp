package com.example.expenseapp;

public class IncomeCategory extends Category{
    private IncomeCategoryType type;

    public IncomeCategory(String name, CategoryType description, IncomeCategoryType type) {
        super(name, description);
        this.type = type;
    }

    public IncomeCategoryType getType() {
        return type;
    }

    public void setType(IncomeCategoryType type) {
        this.type = type;
    }
}
