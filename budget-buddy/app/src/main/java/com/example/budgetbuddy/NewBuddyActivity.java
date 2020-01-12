package com.example.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Hashtable;

public class NewBuddyActivity extends AppCompatActivity {

  String username = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Intent intent = getIntent();
    username = intent.getStringExtra("username");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.new_buddy);
  }

  public void search(View view) {
    EditText buddyText = (EditText) findViewById(R.id.buddy_field);
    String buddyUserName = buddyText.getText().toString();

    TextView addBuddy = (TextView) findViewById(R.id.buddy_status);
    if (username.equals(buddyUserName)) {
      addBuddy.setText("You can't add yourself as a buddy!");
    } else if (((Hashtable) LoginActivity.accounts).containsKey(buddyUserName)) {
      addBuddy.setText("You are now " + buddyUserName + "'s Buddy!");
    } else {
      addBuddy.setText("Buddy not found! Please enter a new username.");
    }
  }

  public void goToTracker(View view) {
    Intent intent = new Intent(this, MainActivity.class);
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
