package dev.james.wellness;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // Login
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        Button signupButton = findViewById(R.id.signUpButton);

        signupButton.setOnClickListener(view -> {
            if (!usernameNotTaken(username)) {
                Toast.makeText(SignUpActivity.this, "Username Already Taken", Toast.LENGTH_SHORT).show();
            }

            saveNewUser(username, password);

            // Send user to the profile page
            Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }

    private void saveNewUser(TextView username, TextView password) {
        //Nothing to do without persistent data storage.
    }

    private boolean usernameNotTaken(TextView username) {
        return true;
    }
}
