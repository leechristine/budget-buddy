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



    TextView addBuddy = (TextView) findViewById(R.id.buddy_status);
    if (LoginActivity.accounts.get(buddy)!= null){
      addBuddy.setText("You are now " + )
    } else {
      return false;
    }
  }


}
