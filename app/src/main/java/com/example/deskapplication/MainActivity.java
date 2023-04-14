package com.example.deskapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.loginButton);
        TextView usernameTextField = findViewById(R.id.userNameInputField);
        loginButton.setOnClickListener(view -> {
                    String username = usernameTextField.getText().toString();
                    Intent intent = (new Intent(MainActivity.this, MainMenuActivity.class));
                    intent.putExtra("username", username);
                    intent.putExtra("project", "X-Quality");
                    intent.putExtra("percentage", 50);
                    startActivity(intent);
                }
        );
    }
}