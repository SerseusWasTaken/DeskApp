package com.example.deskapplication.misc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.deskapplication.MainActivity;
import com.example.deskapplication.MainMenuActivity;
import com.example.deskapplication.R;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Button mainMenuButton = findViewById(R.id.backToMainMenuButton);
        mainMenuButton.setOnClickListener(view -> finish());
    }
}