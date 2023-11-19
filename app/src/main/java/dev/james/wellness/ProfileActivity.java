package dev.james.wellness;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dev.james.wellness.listener.SeekBarChangeListener;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Target Weight
        SeekBar weightSlider = findViewById(R.id.weightSlider);
        TextView weightValue = findViewById(R.id.weightValue);
        SeekBarChangeListener.setupSeekBarChangeListener(weightSlider, weightValue, 1);

        // Target Steps
        SeekBar stepsSlider = findViewById(R.id.stepsSlider);
        TextView stepsValue = findViewById(R.id.stepsValue);
        SeekBarChangeListener.setupSeekBarChangeListener(stepsSlider, stepsValue, 250);

        // Target Sleep
        SeekBar sleepSlider = findViewById(R.id.sleepSlider);
        TextView sleepValue = findViewById(R.id.sleepValue);
        SeekBarChangeListener.setupSeekBarChangeListener(sleepSlider, sleepValue, 1);
    }
}
