package com.example.chad.fruitmachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import static android.R.attr.value;
import static android.media.CamcorderProfile.get;

/**
 * Created by chad on 03/11/2017.
 */

public class FruitMachine {
    private ArrayList<Reel> reels;
    private ArrayList<Symbol> resultReel;
    private int funds;
    private int costPerSpin;

    public FruitMachine(int numReels, int funds) {
        this.resultReel = new ArrayList<>();
        this.reels = new ArrayList<>();
        generateReels(numReels);
        this.funds = funds;
        this.costPerSpin = 1;
    }

    public void generateReels(int numReels) {
        for (int i = 0; i < numReels; i++) {
            reels.add(new Reel());
        }
    }

//    ///////////Getters

//    Tested
    public ArrayList<Reel> getReels() {
        return this.reels;
    }

//    Tested
    public int getNumReels() {
        return reels.size();
    }

//    Tested
    public ArrayList<Symbol> getResultReel() {
        return resultReel;
    }

//    Tested
    public Symbol getResultSymbol(int index) {
        return resultReel.get(index);
    }

//    Tested
    public int getFunds() {
        return funds;
    }

//    ///////////Setters
//    Tested
    public void setResultReel(ArrayList<Symbol> results) {
        this.resultReel = results;
    }

//    Tested
    public void payout(int amount) {
        this.funds -= amount;
    }

//    Tested... Not really...
    public int randomGenerator() {
        Random rand = new Random();
        int reelSize = getReels().get(0).getSymbols().size();
        int random = rand.nextInt(reelSize);
        return random;
    }

//    The way this evaluates is that it multiplies the value by the number of slots, but only if all slots match. Tested.
    public int evaluateWinnings() {
        int winnings = 1;
        for (int i=0; i < getNumReels()-1; i++) {

            if (getResultSymbol(i) != getResultSymbol(i+1)) {
                winnings *= 0;
            }
        }
        winnings *= getResultSymbol(0).getValue() * getNumReels();
        payout(winnings);
        return winnings;
    }

//    public int getJackPot() {
//        ArrayList<Symbol> symbols = reels.get(0).getSymbols();
//        for (Symbol fruit: symbols) {
//
//        }
//    }

    //    Tested
    public ArrayList<Symbol> spin() {
        this.funds += this.costPerSpin;
        for (Reel reel : this.reels) {
            resultReel.add(reel.getSymbols().get(randomGenerator()));
        }
        return getResultReel();
    }

//    Tested
    public String postGameMessage() {
        if (evaluateWinnings() > 1) {
            return "Congratulations, you've rolled " + getNumReels() + " " + getResultSymbol(0).getFruit() + "S! You've won £" + evaluateWinnings();
        } else {
            return "Sorry, you didn't win anything.";
        }
    }

//    Indirectly tested...
    public String play() {
        spin();
        evaluateWinnings();
        return postGameMessage();
    }
}
