package com.example.projectmobiledevelopment;


import android.app.Activity;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.FailureHandler;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.matcher.ViewMatchers;

import com.example.projectmobiledevelopment.Classes.RecAdapter;
import com.example.projectmobiledevelopment.Fragments.MainActivity;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.openLinkWithText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.TestCase.fail;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class BlackboxTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {
    }

    @Test
    public void testAddDog() {
        // clicks the add button
        onView(withId(R.id.btn_insertDog)).perform(click());
        onView(withId(R.id.register_dog_name)).perform(typeText("kelly"));
        onView(withId(R.id.register_dog_age)).perform(typeText("2"));
        onView(withId(R.id.register_dog_race)).perform(typeText("Greyhound"));
        onView(withId(R.id.register_owner_name)).perform(scrollTo(), typeText("Tom"));
        onView(withId(R.id.register_owner_number)).perform(scrollTo(), typeText("12345678"));
        onView(withId(R.id.register_owner_epost)).perform(scrollTo(), typeText("mail@gmail.com"));
        onView(withId(R.id.register_special)).perform(scrollTo(), typeText("kelly has a injury, and needs medisin every day"));
        onView(withId(R.id.btn_register_submit)).perform(scrollTo(), click());

        // if we see the home page we know the code sucessfully have gone through
        // and through the database test we are testing the add functionality
        // this means the item is there
        onView(withId(R.id.textview_notification)).perform(scrollTo()).check(matches(withText("Home")));

        // now we will check if it is in the recyclerview
        onView(withId(R.id.btn_dogs)).perform(scrollTo(), click());

        onView(withId(R.id.rec_dogList)).perform(RecyclerViewActions.scrollToPosition(5));

    }

}
