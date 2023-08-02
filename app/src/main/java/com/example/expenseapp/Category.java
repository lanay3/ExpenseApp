package com.example.expenseapp;

public abstract class Category {
    private String name;
    private CategoryType description;

    public Category(String name, CategoryType description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(CategoryType description) {
        this.description = description;
    }

    public CategoryType getDescription() {
        return description;
    }

}
