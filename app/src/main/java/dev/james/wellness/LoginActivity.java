package dev.james.wellness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Login
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {
            if (validCredentials(username, password)) {
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "Username Or Password Incorrect", Toast.LENGTH_SHORT).show();
            }
        });

        // Terms Of Use and Privacy Policy
        TextView termsOfUse = findViewById(R.id.termsOfUse);
        TextView privacyPolicy = findViewById(R.id.privacyPolicy);

        termsOfUse.setOnClickListener(this::showTermsOfUsePopup);
        privacyPolicy.setOnClickListener(this::showPrivacyPolicyPopup);

        // Sign Up
        TextView signUpTextView = findViewById(R.id.signUp);

        signUpTextView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

    }

    private boolean validCredentials(TextView username, TextView password) {
        return username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin");
    }

    private void showTermsOfUsePopup(View anchorView) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.terms_of_use_popup, null);

        TextView termsTextView = popupView.findViewById(R.id.terms_of_use_popup_text);

        String formattedTerms = getString(R.string.terms_of_use, getString(R.string.app_name));
        termsTextView.setText(Html.fromHtml(formattedTerms, 1));

        PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        popupView.setOnTouchListener((view, event) -> {
            view.performClick();
            popupWindow.dismiss();
            return true;
        });

        popupWindow.showAtLocation(anchorView, Gravity.CENTER, 0, 0);
    }

    private void showPrivacyPolicyPopup(View anchorView) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.privacy_policy_popup, null);

        TextView termsTextView = popupView.findViewById(R.id.privacy_policy_popup_text);

        String formattedTerms = getString(R.string.privacy_policy, getString(R.string.app_name));
        termsTextView.setText(Html.fromHtml(formattedTerms, 1));

        PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        popupView.setOnTouchListener((view, event) -> {
            view.performClick();
            popupWindow.dismiss();
            return true;
        });

        popupWindow.showAtLocation(anchorView, Gravity.CENTER, 0, 0);
    }

}