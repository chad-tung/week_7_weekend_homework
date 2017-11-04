package com.example.chad.fruitmachine;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by chad on 03/11/2017.
 */

public class Reel {
    private ArrayList<Symbol> symbols;

    public Reel() {
        symbols = new ArrayList<>();
        generateSymbols();
    }

    public Reel(Enum other) {

    }

    public void generateSymbols() {
        for (Fruit fruit: Fruit.values()) {
            symbols.add(new Symbol(fruit));
        }
    }

    public ArrayList<Symbol> getSymbols() {
        return symbols;
    }

    public int getJackPot() {
        int jackPot = 0;
        ArrayList<Symbol> symbolList = symbols;
        for (int i = 0; i < symbolList.size()-1; i++) {
            if (symbolList.get(0).getValue() < symbolList.get(1).getValue()) {
                jackPot = symbolList.get(1).getValue();
                symbolList.remove(0);
            }
            else {
                jackPot = symbolList.get(0).getValue();
                symbolList.remove(1);
            }
        }
        return jackPot;
    }

}
