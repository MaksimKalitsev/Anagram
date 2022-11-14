package ua.com.foxminded.anagrams;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.test.espresso.Espresso;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.SmallTest;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@SmallTest

public class StringUtilsInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkStringWithOutIgnoredSymbols() {
        Espresso.onView(withId(R.id.sentence_et)).perform(ViewActions.typeText("qwerty"),
                ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.convert_btn)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.result_tv)).check(matches(withText("ytrewq")));
    }

    @Test
    public void checkButton() {
        Espresso.onView(withId(R.id.convert_btn)).check(matches(withId(R.id.convert_btn)));
    }

    @Test
    public void checkMultipleString() {
        Espresso.onView(withId(R.id.sentence_et)).perform(ViewActions.typeText("qwerty\nasdfgh"),
                ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.convert_btn)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.result_tv)).check(matches(withText("ytrewq\nhgfdsa")));
    }

    @Test
    public void checkStringWithIgnoredSymbols() {
        Espresso.onView(withId(R.id.sentence_et)).perform(ViewActions.typeText("Foxminded cool 24/7"));
        Espresso.onView(withId(R.id.ignoredsymbols_et)).perform(ViewActions.typeText("xl"),
                ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.convert_btn)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.result_tv)).check(matches(withText("dexdnimoF oocl 7/42")));
    }

    @Test
    public void buttonOnDisplay() {
        Espresso.onView(withId(R.id.convert_btn)).check(matches(isDisplayed()));
    }

    @Test
    public void editTextSentenceOnDisplay() {
        Espresso.onView(withId(R.id.sentence_et)).check(matches(isDisplayed()));
    }

    @Test
    public void editTextIgnoredSymbolsOnDisplay() {
        Espresso.onView(withId(R.id.ignoredsymbols_et)).check(matches(isDisplayed()));
    }

    @Test
    public void textViewResultOnDisplay() {
        Espresso.onView(withId(R.id.result_tv)).check(matches(isDisplayed()));
    }
}
