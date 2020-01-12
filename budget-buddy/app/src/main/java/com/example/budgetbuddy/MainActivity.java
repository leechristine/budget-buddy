package com.example.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String username = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView transactionHistory = (TextView) findViewById(R.id.transaction_history);
        ArrayList<String> userData = LoginActivity.accounts.get(username);
        String transactionHistory = userData.get(7);
        String[] userDataArray = transactionHistory.split("|");
        transactionHistory.setText(currentTransactionHistory(userDataArray));
    }


    public void transaction(View view) {
        Intent intent = new Intent(this, TransactionActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public String currentTransactionHistory(String[] userDataArray) {
        String history;
        for (int i=0; i<userDataArray.length(); i++){
            String[] transactionDataArray = userDataArray[i].split(":");
            history=transactionDataArray[0]+transactionDataArray[1]+transactionDataArray[2]+transactionDataArray[3]+"\n";
        }
        return history;
    }
}
