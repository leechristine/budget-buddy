package com.example.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TransactionActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener {

  String username = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Intent intent = getIntent();
    username = intent.getStringExtra("username");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.transaction);

    Spinner categories = findViewById(R.id.category_options);
    ArrayAdapter<CharSequence> adapter =
        ArrayAdapter.createFromResource(
            this, R.array.categories, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    categories.setAdapter(adapter);
    categories.setOnItemSelectedListener(this);
  }

  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String category = parent.getItemAtPosition(position).toString();
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {}

  public void newTransactionHistory(View view) {
    ArrayList<String> userData = LoginActivity.accounts.get(username);
    String transactionHistory = userData.get(7);

    EditText monthText = (EditText) findViewById(R.id.month_field);
    String month = monthText.getText().toString();

    EditText dayText = (EditText) findViewById(R.id.day_field);
    String day = dayText.getText().toString();

    EditText yearText = (EditText) findViewById(R.id.year_field);
    String year = yearText.getText().toString();

    EditText costText = (EditText) findViewById(R.id.cost_field);
    String cost = costText.getText().toString();

    Spinner categories = (Spinner) findViewById(R.id.category_options);
    String category = categories.getSelectedItem().toString();

    EditText descriptionText = (EditText) findViewById(R.id.description_field);
    String description = descriptionText.getText().toString();

    String updTransactionHistory =
        transactionHistory
            + "|"
            + month
            + "/"
            + day
            + "/"
            + year
            + ", "
            + cost
            + ", "
            + category
            + ", "
            + description
            + "/n";
    userData.set(7, updTransactionHistory);
    LoginActivity.accounts.put(username, userData);

    Intent intent = new Intent(this, MainActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }
}
