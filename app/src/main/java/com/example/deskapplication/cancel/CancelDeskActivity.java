package com.example.deskapplication.cancel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.deskapplication.R;

public class CancelDeskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_desk);

        Button cancelOwnDeskButton = findViewById(R.id.cancelOwnDeskButton);
        cancelOwnDeskButton.setOnClickListener(view -> startActivity(new Intent(CancelDeskActivity.this, CancelDeskDetailActivity.class)));
    }
}