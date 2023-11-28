package dev.james.wellness;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.intent.rule.IntentsRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;

@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Rule
    public IntentsRule intentsTestRule = new IntentsRule();

    @Test
    public void testLoginScreenLoadedCorrectly() {
        onView(withId(R.id.signinlabel)).check(matches(isDisplayed()));
        onView(withId(R.id.username)).check(matches(isDisplayed()));
        onView(withId(R.id.usernameErrorText)).check(matches(isDisplayed()));
        onView(withId(R.id.password)).check(matches(isDisplayed()));
        onView(withId(R.id.forgotPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordErrorText)).check(matches(isDisplayed()));
        onView(withId(R.id.loginErrorText)).check(matches(isDisplayed()));
        onView(withId(R.id.loginButton)).check(matches(isDisplayed()));
        onView(withId(R.id.termsOfUse)).check(matches(isDisplayed()));
        onView(withId(R.id.divider)).check(matches(isDisplayed()));
        onView(withId(R.id.privacyPolicy)).check(matches(isDisplayed()));
        onView(withId(R.id.signUp)).check(matches(isDisplayed()));
    }

    @Test
    public void testInputFields() {
        // Input some text into the username field
        onView(withId(R.id.username)).perform(typeText("testuser"), closeSoftKeyboard());

        // Input some text into the password field
        onView(withId(R.id.password)).perform(typeText("testpassword"), closeSoftKeyboard());

        // Verify if the entered text matches in both fields
        onView(withId(R.id.username)).check(matches(withText("testuser")));
        onView(withId(R.id.password)).check(matches(withText("testpassword")));
    }

    @Test
    public void testSignUpLinkClick() {
        // Click on the "Sign Up" link
        onView(withId(R.id.signUp)).perform(click());

        // Verify that the expected intent was sent to open the SignUpActivity
        intended(IntentMatchers.hasComponent(SignUpActivity.class.getName()));
    }

    @Test
    public void testTermsOfUsePopup() {
        // Click the Terms of Use Text to bring up the popup
        onView(withId(R.id.termsOfUse)).perform(click());

        onView(withId(R.id.terms_of_use_popup_text)).check(matches(isDisplayed()));
    }

    @Test
    public void testPrivacyPolicyPopup() {
        // Click the Terms of Use Text to bring up the popup
        onView(withId(R.id.privacyPolicy)).perform(click());

        onView(withId(R.id.privacy_policy_popup_text)).check(matches(isDisplayed()));
    }
}
