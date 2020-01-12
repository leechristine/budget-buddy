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

    TextView transactionHistory = (TextView) findViewById(R.id.transaction_history);
    ArrayList<String> userData = LoginActivity.accounts.get(username);
    transactionHistory.setText(userData.get(7));
  }

  public void goToTransaction(View view) {
    Intent intent = new Intent(this, TransactionActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }

  public void logOut(View view) {
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
  }
}
