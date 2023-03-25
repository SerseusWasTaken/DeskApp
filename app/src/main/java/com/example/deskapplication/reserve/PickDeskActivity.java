package com.example.deskapplication.reserve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.deskapplication.MainMenuActivity;
import com.example.deskapplication.R;

public class PickDeskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_desk);
        Button requestDeskButton = findViewById(R.id.requestDeskButton);
        requestDeskButton.setOnClickListener(view -> startActivity(new Intent(PickDeskActivity.this, MainMenuActivity.class)));
        Button hiddenButton = findViewById(R.id.hiddenButton);
        hiddenButton.setOnClickListener(view -> startActivity(new Intent(PickDeskActivity.this, RequestDeskReleaseActivity.class)));
    }
}