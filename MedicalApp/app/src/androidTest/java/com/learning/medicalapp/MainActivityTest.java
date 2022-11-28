package com.learning.medicalapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.test.annotation.UiThreadTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.learning.medicalapp.utility.FileUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class MainActivityTest {
    private Button mButtonSave;
    private Button mButtonShow;
    private TextView mContentTextView;
    private Instrumentation mInstrumentation;
    private Activity mActivity;
    //new rule
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);


    @Before
    public void setUp() throws Exception {
        mInstrumentation = InstrumentationRegistry.getInstrumentation();
        mActivity = mActivityRule.getActivity();
        mButtonSave = (Button) mActivity.findViewById(R.id.saveButton);
        mButtonShow = (Button) mActivity.findViewById(R.id.showButton);
        mContentTextView = (TextView) mActivity.findViewById(R.id.text_view);
    }

    @Test
    public void testLaunch() {
        View view = mActivity.findViewById(R.id.buttonLayout);
        assertNotNull(view);
    }

    @UiThreadTest
    @Test
    public void testSetProperties() {
        // setClickable, setOnClickListener
//        mButtonShow.setClickable(true);
//        assertTrue(mButtonShow.isClickable());

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveButtonClick() {
        onView(withId(R.id.saveButton)).perform(click());
    }

    @Test
    public void showButtonClick() {
        onView(withId(R.id.showButton)).perform(click());
    }

    @Test
    public void testUpdatedUserListNotEmpty() {
        String conent = FileUtil.readContentFromFile("DeviceUserListUpdated.txt");
        onView(withId(R.id.text_view))
                .check(matches(withText(containsString(conent))));
    }
}