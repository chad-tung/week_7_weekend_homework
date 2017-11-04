package com.example.chad.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chad on 03/11/2017.
 */

public class ReelTest {

    Reel reel;

    @Before
    public void setUp() throws Exception {
        reel = new Reel();
    }

    @Test
    public void testReelSize() {
        assertEquals(9, reel.getSymbols().size());
    }

    @Test
    public void canGetJackpotValue() {
        assertEquals(100, reel.getJackPot());
    }
}
