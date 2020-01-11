package com.example.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.*;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }


    public void login(View view){


    }

    public void createAccount(View view){
        NewAccount newacc = new NewAccount();
        //Button
        //newacc.onCreate();

    }
}
