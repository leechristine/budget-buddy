package com.example.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.*;


public class NewAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_account);
    }

    Dictionary accounts = new Hashtable(); //should be global??

    public void createAccount(View view){ //check if the user entered the correct stuff

        ArrayList<String> newAccount = new ArrayList<String>();

        EditText nameText = (EditText)findViewById(R.id.name_field);
        String username = nameText.getText().toString();
        newAccount.add(username);

        EditText passwordText = (EditText)findViewById(R.id.name_field);
        String password = passwordText.getText().toString();
        newAccount.add(password);

        EditText budgetText = (EditText)findViewById(R.id.budget_field);
        String budget = budgetText.getText().toString();
        newAccount.add(budget);
//        String value = budgetText.getText().toString();
//        budget  = Float.parseFloat(value);

        EditText goalText = (EditText)findViewById(R.id.goal_field);
        String goal = goalText.getText().toString();
        newAccount.add(goal);

        accounts.put(username, newAccount);

        System.out.println(accounts);
    }

}
