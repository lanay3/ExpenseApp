package com.example.expenseapp;

public class ExpenseCategory extends Category {
   private ExpenseCategoryType type;

   public ExpenseCategory(String name, CategoryType description, ExpenseCategoryType type) {
      super(name, description);
      this.type = type;
   }

   public ExpenseCategoryType getType() {
      return type;
   }

   public void setType(ExpenseCategoryType type) {
      this.type = type;
   }

}
