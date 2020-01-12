package com.example.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  String username = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Intent intent = getIntent();
    username = intent.getStringExtra("username");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ArrayList<String> userData = LoginActivity.accounts.get(username);

    // Set all recorded transactions.
    TextView transactionHistory = (TextView) findViewById(R.id.transaction_history);
    transactionHistory.setText(userData.get(7));

    // Set name of user in greeting.
    TextView nameGreeting = (TextView) findViewById(R.id.text_hi);
    nameGreeting.setText("Hi " + userData.get(1) + "!");
  }

  public void goToTransaction(View view) {
    Intent intent = new Intent(this, TransactionActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }

  public void goToBuddy(View view) {
    Intent intent = new Intent(this, NewBuddyActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
    finish();
    overridePendingTransition(0, 0);
  }

  public void logOut(View view) {
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
  }
}
