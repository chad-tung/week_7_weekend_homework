package com.example.chad.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by chad on 05/11/2017.
 */

public class PlayerTest {
    Player player1;
    FruitMachine fruitMachine;
    FruitMachine spyMachine1;
    ArrayList<Symbol> mockitoResult1;
    ArrayList<Symbol> mockitoResult2;
    Symbol symbolSEVEN = new Symbol(Fruit.SEVEN);

    @Before
    public void before() {
        player1 = new Player("Chad", 5);
        fruitMachine = new FruitMachine(3, 400);
        spyMachine1 = Mockito.spy(fruitMachine);

        Symbol symbol1 = symbolSEVEN;
        Symbol symbol2 = new Symbol(Fruit.BAR);
        mockitoResult1 = new ArrayList<>();
        mockitoResult2 = new ArrayList<>();

        for (int i = 0; i < spyMachine1.getReels().size(); i++) {
            mockitoResult1.add(symbol1);
            mockitoResult2.add(symbol2);
        }
    }

    @Test
    public void canAddFunds() {
        player1.visitAtm(10);
        assertEquals(15, player1.getFunds());
    }

    @Test
    public void canPayIn() {
        player1.payIn(fruitMachine);
        assertEquals(4, player1.getFunds());
    }

    @Test
    public void canCollectWinnings() {
//        Thought I was going crazy, but forgot we only manipulate what a function outputs when we use Mockito, not the actual result of what that function actually randomly generates and writes. Have to also set the result reel equal to the mockito result. Don't know if this is a good way to test. I know that what I've written should mean that whatever is spun is set to the result reel, but I can't say that I've tested it, except for the fact that when I call spin, the result reel increases in size. Not sure if this violates the Open to expansion, closed for modification,


//        Pay in the money
        player1.payIn(spyMachine1);
//        spin the wheel. Currently have the spin function to implement the addition of the payIn value, although I think this is incorrect. It could be better to have payIn to make the machine funds increase, since the machine is passed in as an argument.
        Mockito.when(spyMachine1.spin()).thenReturn(mockitoResult1);
        spyMachine1.spin();
        spyMachine1.setResultReel(mockitoResult1);
//        collect any winnings, this should update the machine funds and player's funds.
        player1.collectWinnings(spyMachine1);
        assertEquals(304, player1.getFunds());
        assertEquals(101, spyMachine1.getFunds());
    }
}
