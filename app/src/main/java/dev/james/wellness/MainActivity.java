package dev.james.wellness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {
            if (validCredentials(username, password)) {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Username Or Password Incorrect", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean validCredentials(TextView username, TextView password) {
        return username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin");
    }
}