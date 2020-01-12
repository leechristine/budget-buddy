package com.example.budgetbuddy;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewBuddyActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.transaction);

    EditText buddyText = (EditText) findViewById(R.id.buddy_field);
    String buddyUserName = buddyText.getText().toString();

    TextView addBuddy = (TextView) findViewById(R.id.buddy_status);
    if (LoginActivity.accounts.get(buddyUserName) != null) {
      addBuddy.setText("You are now " + buddyUserName + "'s Buddy!");
    } else {
      addBuddy.setText("Buddy not found! Please enter a new username.");
    }
  }
}
