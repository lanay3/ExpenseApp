package com.example.expenseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TransactionAdapter extends ArrayAdapter<Transaction> {
    private Context context;
    private List<Transaction> transactions;

    public TransactionAdapter(Context context, List<Transaction> transactions) {
        super(context, R.layout.list_item, transactions);
        this.context = context;
        this.transactions = transactions;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Transaction currentTransaction = transactions.get(position);

        TextView name = convertView.findViewById(R.id.transactionNameTextView);
        TextView amount = convertView.findViewById(R.id.transactionAmountTextView);
        TextView date = convertView.findViewById(R.id.transactionDateTextView);

        name.setText(currentTransaction.getName());
        amount.setText(String.valueOf(currentTransaction.getAmount()));
        date.setText(currentTransaction.getDate());

        return convertView;
    }
}
