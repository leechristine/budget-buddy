package com.example.budgetbuddy;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
public class NewBuddyActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.transaction);

    EditText buddyText = (EditText) findViewById(R.id.buddy_field);
    String buddyUserName = buddyText.getText().toString();

    TextView addBuddy = (TextView) findViewById(R.id.buddy_status);
    if (LoginActivity.accounts.get(buddyUserName)!= null){
      addBuddy.setText("You are now " + buddyUserName + "'s Buddy!" )
    } else {
      addBuddy.setText("Buddy not found! Please enter a new username.")
    }
  }


}
