package com.example.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Intent intent = getIntent();
    String username = intent.getStringExtra("username");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
