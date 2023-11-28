package dev.james.wellness.util;

import android.widget.TextView;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.mockito.Mockito;

public class FormValidationTest {

    @Test
    public void testFieldNotEmptyWithStringText() {
        TextView textViewMock = Mockito.mock(TextView.class);
        Mockito.when(textViewMock.getText()).thenReturn("Sample text");

        assertFalse(FormValidation.verifyFieldNotEmpty(textViewMock));
    }

    @Test
    public void testFieldNotEmptyWithNumbers() {
        TextView textViewMock = Mockito.mock(TextView.class);
        Mockito.when(textViewMock.getText()).thenReturn("Sample 12 text");

        assertFalse(FormValidation.verifyFieldNotEmpty(textViewMock));
    }

    @Test
    public void testFieldNotEmptyWithSpecialCharacters() {
        TextView textViewMock = Mockito.mock(TextView.class);
        Mockito.when(textViewMock.getText()).thenReturn("?!@");

        assertFalse(FormValidation.verifyFieldNotEmpty(textViewMock));
    }

    @Test
    public void testFieldNotEmptyWithEmptyText() {
        TextView textViewMock = Mockito.mock(TextView.class);
        Mockito.when(textViewMock.getText()).thenReturn("");

        assertTrue(FormValidation.verifyFieldNotEmpty(textViewMock));
    }
}
