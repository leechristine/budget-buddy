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
    String username = intent.getStringExtra("username");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView transactionHistory = (TextView) findViewById(R.id.transaction_history);
    transactionHistory.setText(currentTransactionHistory());
  }

  public void transaction(View view) {
    Intent intent = new Intent(this, TransactionActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }

  public String currentTransactionHistory() {
    ArrayList<String> userData = LoginActivity.accounts.get(username);
    String transactionHistory = userData.get(7);
    String[] userDataArray = transactionHistory.split("|");
    String history = "";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < userDataArray.length; i++) {
      String[] transactionDataArray = userDataArray[i].split(":");
      for (int j = 0; j < transactionDataArray.length; j++) {
        history = sb.append(userDataArray[j] + ", ");
      }
      history = sb.append("/n");
    }

    return history;
  }
}
