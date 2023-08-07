package com.example.expenseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.SurfaceControl;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TransactionManger";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TRANSACTION = "transaction";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AMOUNT = " amount";
    private static final String KEY_DATE = "date";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_TYPE = "type";

    private static final String KEY_EXTRA = "specification";

    private static final String CREATE_TABLE_TRANSACTION = "CREATE TABLE " + "\"" + TABLE_TRANSACTION + "\"" + " ("
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_NAME + " TEXT, "
            + KEY_AMOUNT + " REAL, "
            + KEY_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
            + KEY_CATEGORY + " TEXT, "
            + KEY_TYPE + " TEXT"
            + KEY_EXTRA + "TEXT"
            + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TRANSACTION);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + "\"" + TABLE_TRANSACTION + "\"" );
        onCreate(db);
    }

    public void addTransaction(Transaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // values.put(KEY_ID, transaction.getId());
        values.put(KEY_NAME, transaction.getName());
        values.put(KEY_AMOUNT, transaction.getAmount());
        values.put(KEY_DATE, transaction.getDate());
        values.put(KEY_CATEGORY, transaction.getName());
        values.put(KEY_TYPE, transaction.getType().toString());
        //values.put(KEY_EXTRA, transaction.getExtra());

        db.insert(TABLE_TRANSACTION, null, values);
        db.close();
    }

    public void deleteTransaction(Transaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRANSACTION, KEY_ID + " = ?",
                new String[] {String.valueOf(transaction.getId())});
        db.close();
    }

    public int updateTransaction(Transaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // values.put(KEY_ID, transaction.getId());
        values.put(KEY_NAME, transaction.getName());
        values.put(KEY_AMOUNT, transaction.getAmount());
        values.put(KEY_DATE, transaction.getDate());
        values.put(KEY_CATEGORY, transaction.getName());
        values.put(KEY_TYPE, transaction.getType().toString());
        //values.put(KEY_EXTRA, transaction.getExtra());

        return db.update(TABLE_TRANSACTION, values, KEY_ID + " = ?",
                new String[] {String.valueOf(transaction.getId())});
    }

    public Transaction getTransaction(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TRANSACTION, new String[] {KEY_ID, KEY_NAME,
                KEY_AMOUNT, KEY_DATE, KEY_CATEGORY, KEY_TYPE}, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
//        CategoryType catType = CategoryType.valueOf(cursor.getString(5));
//        if (catType.equals(CategoryType.EXPENSE_CATEGORY)) {
//           Category category = new ExpenseCategory(cursor.getString(4), catType);
//        }

        Category category = createCategory(cursor.getString(4));

        TransactionType type = TransactionType.valueOf(cursor.getString(5));

        Transaction transact;

        switch(type) {
            case INCOME:
//                IncomeCategory cat = new IncomeCategory()
                transact = new Income(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getDouble(2),
                        cursor.getString(3),
                        category,
                        type
                );
                break;
            case EXPENSE:
                transact = new Expense(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getDouble(2),
                        cursor.getString(3),
                        category,
                        type
                );
                break;
            default:
                transact = null;
        }

        return transact;
    }

    public Category createCategory(String category) {
        String[] part = category.split(":");

        String catName = part[0];
        CategoryType catDesc = CategoryType.valueOf(part[1]);
        String catType = part.length > 2 ? part[2]: null;

        switch(catDesc)  {
            case EXPENSE_CATEGORY:
                return new ExpenseCategory(catName, catDesc, ExpenseCategoryType.valueOf(catType));
            case INCOME_CATEGORY:
                return new IncomeCategory(catName, catDesc, IncomeCategoryType.valueOf(catType));
            default:
                throw new IllegalArgumentException("Invalid category description");
        }
    }
}
