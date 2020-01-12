package com.example.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class LoginActivity extends AppCompatActivity {

  static Dictionary<String, ArrayList<String>> accounts = new Hashtable<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);
  }

  public void login(View view) {
    boolean loginSuccess = false;

    EditText nameText = (EditText) findViewById(R.id.username_field);
    String username = nameText.getText().toString();

    EditText passwordText = (EditText) findViewById(R.id.password_field);
    String password = passwordText.getText().toString();

    for (int i = 0; i < accounts.size(); i++) {
      ArrayList<String> userInfo = accounts.get(username);
      if (userInfo != null && userInfo.get(2).equals(password)) {
        loginSuccess = true;
      }
    }

    if (loginSuccess) {
      Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);
    }
  }

  public void createAccount(View view) {
    RegisterActivity newAcc = new RegisterActivity();
    // Button
    // newAcc.onCreate();

  }

  /** Go to RegisterActivity */
  public void goToRegister(View view) {
    Intent intent = new Intent(this, RegisterActivity.class);
    startActivity(intent);
  }

  //    /** Go to MainActivity after log-in */
  //    public void goToMain(View view) {
  //        Intent intent = new Intent(this, MainActivity.class);
  //        startActivity(intent);
  //    }
}
