package com.example.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Dictionary;

public class RegisterActivity extends AppCompatActivity {

  Dictionary<String, ArrayList<String>> accounts;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    accounts = LoginActivity.accounts;
    super.onCreate(savedInstanceState);
    setContentView(R.layout.register);
  }

  /** Go to LoginActivity */
  public void createAccount(View view) { // check if the user entered the correct stuff
    ArrayList<String> newAccount = new ArrayList<String>();

    // username: index 0
    EditText usernameText = (EditText) findViewById(R.id.username_field);
    String username = usernameText.getText().toString();
    newAccount.add(username);

    // name: index 1
    EditText nameText = (EditText) findViewById(R.id.name_field);
    String name = nameText.getText().toString();
    newAccount.add(name);

    // password: index 2
    EditText passwordText = (EditText) findViewById(R.id.password_field);
    String password = passwordText.getText().toString();
    newAccount.add(password);

    // budget: index 3
    EditText budgetText = (EditText) findViewById(R.id.budget_field);
    String budget = budgetText.getText().toString();
    newAccount.add(budget);

    // goal amount: index 4
    EditText goalAmountText = (EditText) findViewById(R.id.goal_amount_field);
    String goalAmount = goalAmountText.getText().toString();
    newAccount.add(goalAmount);

    // goal date: index 5
    EditText goalDateText = (EditText) findViewById(R.id.goal_date_field);
    String goalDate = goalDateText.getText().toString();
    newAccount.add(goalDate);

    // goal purpose: index 6
    EditText goalPurposeText = (EditText) findViewById(R.id.goal_purpose_field);
    String goalPurpose = goalPurposeText.getText().toString();
    newAccount.add(goalPurpose);

    // spending history: index 7
    newAccount.add("0");

    // adding the user date to a dictionary where the key is the username and the value is the
    // arraylist made up of its data
    accounts.put(username, newAccount);

    // opens the login screen
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
  }
}
