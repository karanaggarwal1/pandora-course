package com.example.karan.unittestsinterestcalculator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Karan on 26-02-2017.
 * for instrumentation tes
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public final ActivityTestRule<MainActivity> act = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity;

    @Before
    public void setUpActivity() {
        mainActivity = act.getActivity();
    }

    @Test
    public void interestCalculation_isCorrect() throws Exception {
        //initially we are not on UI thread
        //to make such a thing happen, we need to execute this function with an object of type runnable

        mainActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                mainActivity.etInterest.setText(10 + "");
                mainActivity.etPrincipal.setText(100 + "");
                mainActivity.etYears.setText(1 + "");
                mainActivity.btnCalculateInterest.performClick();
                float amount = Float.valueOf(mainActivity.tvAmount.getText().toString());
                assertEquals(110, amount, 0.001);
            }
        });
    }
}
