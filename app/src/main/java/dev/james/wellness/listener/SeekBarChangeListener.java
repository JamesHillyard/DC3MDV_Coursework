package dev.james.wellness.listener;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * This class is used to setup a Seek Bar Change Listener that will update a TextView with the
 * value of the seekbar. This utility class also implements a step value functionality which is
 * not provided by Android.
 *
 * @author James Hillyard
 */
public class SeekBarChangeListener {

    public static void setupSeekBarChangeListener(SeekBar seekBar, final TextView valueText, int stepValue) {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Modify the Progress to be with the step value
                progress = Math.round(progress / (float) stepValue) * stepValue;
                seekBar.setProgress(progress);

                // Update the Supporting Text
                String progressString = String.valueOf(progress);
                valueText.setText(progressString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
