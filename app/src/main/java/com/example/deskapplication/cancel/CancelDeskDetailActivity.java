package com.example.deskapplication.cancel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.deskapplication.MainMenuActivity;
import com.example.deskapplication.R;

public class CancelDeskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_desk_detail);

        Button cancelChosenDeskButton = findViewById(R.id.cancelChosenDeskButton);
        cancelChosenDeskButton.setOnClickListener(view -> startActivity(new Intent(CancelDeskDetailActivity.this, MainMenuActivity.class)));
    }
}