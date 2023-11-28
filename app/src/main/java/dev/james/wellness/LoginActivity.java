package dev.james.wellness;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import dev.james.wellness.util.ErrorMessageWatcher;
import dev.james.wellness.util.FormValidation;

public class LoginActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);

        // Update the error messages on text view changes
        username.addTextChangedListener(new ErrorMessageWatcher(findViewById(R.id.usernameErrorText)));
        password.addTextChangedListener(new ErrorMessageWatcher(findViewById(R.id.passwordErrorText)));

        // Login Button Functionality
        loginButton.setOnClickListener(view -> {
            if (validateForm(username, password)) {
                return; // Don't try and login if the validation failed
            }
            performLogin(username, password);
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

    private void clearErrorMessage(int errorTextId) {
        TextView usernameError = findViewById(errorTextId);
        usernameError.setText("");
    }

    private boolean validateForm(TextView username, TextView password) {
        boolean validationFailed = false;

        if (FormValidation.verifyFieldNotEmpty(username)) {
            TextView usernameError = findViewById(R.id.usernameErrorText);
            usernameError.setText("Please enter a username");
            validationFailed = true;
        }
        if (FormValidation.verifyFieldNotEmpty(password)) {
            TextView usernameError = findViewById(R.id.passwordErrorText);
            usernameError.setText("Please enter a password");
            validationFailed = true;
        }

        return validationFailed;
    }

    private void performLogin(TextView username, TextView password) {
        // Credential Verification
        if (validCredentials(username, password)) {
            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        } else {
            TextView usernameError = findViewById(R.id.loginErrorText);
            usernameError.setText("Username or Password was Incorrect");
        }
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