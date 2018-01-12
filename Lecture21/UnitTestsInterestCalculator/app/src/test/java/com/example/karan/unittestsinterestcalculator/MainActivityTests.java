package com.example.karan.unittestsinterestcalculator;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Karan on 26-02-2017.
 */
/**
 * here classes are not use for OOPS
 * can be used in any manner desirable to developer
 * name of the function -operation_iscorrect
 * delta defines the amount of admissable error
 * we can see the code coverage here
 * static functions-return type is a primitive-run those tests-good practice
 * */
public class MainActivityTests {
    @Test
    public void calcAmount_isCorrect() throws Exception{
        assertEquals(110,MainActivity.calcInterest(100,10,1),0.001);
    }
}
