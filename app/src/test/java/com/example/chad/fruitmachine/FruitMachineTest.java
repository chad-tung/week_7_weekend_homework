package com.example.chad.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by chad on 03/11/2017.
 */

public class FruitMachineTest {

    FruitMachine fruitMachine;
    FruitMachine fruitMachine2;
    FruitMachine spyMachine1;
    FruitMachine spyMachine2;
    ArrayList<Symbol> mockitoResult1;
    ArrayList<Symbol> mockitoResult2;
    ArrayList<Symbol> mockitoResult3;
    Symbol symbolSEVEN = new Symbol(Fruit.SEVEN);

    @Before
    public void before() {
        fruitMachine = new FruitMachine(3, 300);
        fruitMachine2 = new FruitMachine(5, 500);

//        Mockito testing
        spyMachine1 = Mockito.spy(fruitMachine);
        spyMachine2 = Mockito.spy(fruitMachine2);

        Symbol symbol1 = symbolSEVEN;
        Symbol symbol2 = new Symbol(Fruit.BAR);
        mockitoResult1 = new ArrayList<>();
        mockitoResult2 = new ArrayList<>();
        mockitoResult3 = new ArrayList<>();

        for (int i = 0; i < spyMachine1.getReels().size(); i++) {
            mockitoResult1.add(symbol1);
            mockitoResult3.add(symbol1);
        }
        for (int i = 0; i < spyMachine2.getReels().size(); i++) {
            mockitoResult2.add(symbol2);
        }
        mockitoResult3.add(symbol2);
        mockitoResult3.add(symbol2);
    }

    @Test
    public void testFruitMachineReelNumber() {
        assertEquals(3, fruitMachine.getReels().size());
        assertEquals(5, fruitMachine2.getReels().size());
    }

    @Test
    public void testFruitMachineFunds() {
        assertEquals(300, fruitMachine.getFunds());
        assertEquals(500, fruitMachine2.getFunds());
    }

    @Test
    public void testFruitMachinePayout() {
        fruitMachine.payout(50);
        assertEquals(250, fruitMachine.getFunds());
    }

    @Test
    public void testEvaluate() {
        spyMachine1.setResultReel(mockitoResult1);

        assertEquals(300, spyMachine1.evaluateWinnings());

        spyMachine2.setResultReel(mockitoResult2);
        assertEquals(100, spyMachine2.evaluateWinnings());

        spyMachine2.setResultReel(mockitoResult3);
        assertEquals(0, spyMachine2.evaluateWinnings());
    }

    @Test
    public void testSpin() {
        assertEquals(0, fruitMachine.getResultReel().size());
        fruitMachine.spin();
        fruitMachine2.spin();
        assertEquals(3, fruitMachine.getResultReel().size());
        assertEquals(5, fruitMachine2.getResultReel().size());


        ArrayList<Symbol> expected = new ArrayList<>();
        for (int i = 0; i < spyMachine1.getReels().size(); i++) {
            expected.add(symbolSEVEN);
        }

        Mockito.when(spyMachine1.spin()).thenReturn(mockitoResult1);
        assertEquals(expected, spyMachine1.spin());
        assertEquals(3, spyMachine1.getResultReel().size());
        assertEquals(expected, spyMachine1.getResultReel());
//        assertEquals(300, spyMachine1.evaluateWinnings());
    }

    @Test
    public void testPostGameMessage() {
        spyMachine1.setResultReel(mockitoResult1);
        spyMachine2.setResultReel(mockitoResult3);

        assertEquals("Congratulations, you've rolled 3 SEVENS! You've won £300", spyMachine1.postGameMessage());
        assertEquals("Sorry, you didn't win anything.", spyMachine2.postGameMessage());
    }

}
