package dev.james.wellness.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public class ErrorMessageWatcher implements TextWatcher {

    final TextView errorMessageView;

    public ErrorMessageWatcher(TextView errorMessageView) {
        this.errorMessageView = errorMessageView;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        errorMessageView.setText("");
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
