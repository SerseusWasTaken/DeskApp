package com.example.deskapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.deskapplication.cancel.CancelDeskActivity;
import com.example.deskapplication.misc.StatisticsActivity;
import com.example.deskapplication.reserve.PickDateTimeActivity;

public class MainMenuActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent intent = getIntent();
        TextView usernameTextView = findViewById(R.id.usernameTextView);
        usernameTextView.setText("Hallo " + intent.getStringExtra("username") + "("
                + intent.getStringExtra("project") + ", "
                + intent.getIntExtra("percentage", 0) + ")");
        Button reserveDeskButton = findViewById(R.id.reserveDeskButton);
        reserveDeskButton.setOnClickListener(view -> startActivity(new Intent(MainMenuActivity.this, PickDateTimeActivity.class)));
        Button cancelDeskButton = findViewById(R.id.cancelOwnDeskButton);
        cancelDeskButton.setOnClickListener(view -> startActivity(new Intent(MainMenuActivity.this, CancelDeskActivity.class)));
        Button statisticsButton = findViewById(R.id.statisticsButton);
        statisticsButton.setOnClickListener(view -> startActivity(new Intent(MainMenuActivity.this, StatisticsActivity.class)));
    }
}