package com.example.deskapplication.reserve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.deskapplication.R;

public class PickDateTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_date_time);

        Button chooseDeskButton = findViewById(R.id.chooseDeskButton);
        chooseDeskButton.setOnClickListener(view -> startActivity(new Intent(PickDateTimeActivity.this, PickDeskActivity.class)));

    }
}