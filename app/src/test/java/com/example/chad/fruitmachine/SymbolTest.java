package com.example.chad.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chad on 03/11/2017.
 */

public class SymbolTest {
    Symbol symbol1;
    Symbol symbol2;

    @Before
    public void setUp() throws Exception {
        symbol1 = new Symbol(Fruit.APPLE);
        symbol2 = new Symbol(Fruit.BAR);
    }

    @Test
    public void testSymbolGetFruit() {
        assertEquals(Fruit.APPLE, symbol1.getFruit());
        assertEquals(Fruit.BAR, symbol2.getFruit());
    }

    @Test
    public void testSymbolHasValue() {
        assertEquals(2, symbol1.getValue());
        assertEquals(20, symbol2.getValue());
    }
}
