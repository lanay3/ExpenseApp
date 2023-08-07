package com.example.expenseapp;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText expenseEditText;
    private Button addExpenseButton;
    private ListView expenseListView;
    private ArrayList<String> expenses;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        expenseEditText = findViewById(R.id.expenseEditText);
        addExpenseButton = findViewById(R.id.addExpenseButton);
        expenseListView = findViewById(R.id.expenseListView);

        // Initialize the expenses list and adapter
        expenses = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, expenses);
        expenseListView.setAdapter(adapter);

        // Add an expense when the button is clicked
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expense = expenseEditText.getText().toString().trim();
                if (!expense.isEmpty()) {
                    expenses.add(expense);
                    adapter.notifyDataSetChanged();
                    expenseEditText.setText("");
                }
            }
        });
    }
}
