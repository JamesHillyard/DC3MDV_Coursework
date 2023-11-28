package dev.james.wellness.util;

import android.widget.TextView;

public class FormValidation {

    public static boolean verifyFieldNotEmpty(TextView field) {
        return field.getText().toString().isEmpty();
    }
}
