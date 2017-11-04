package com.example.chad.fruitmachine;

/**
 * Created by chad on 03/11/2017.
 */

public class Symbol {
    private Fruit fruit;

    public Symbol(Fruit fruit) {
        this.fruit = fruit;
    }

    public Symbol(Enum other) {

    }

    public Fruit getFruit() {
        return this.fruit;
    }

    public int getValue() {
        return this.fruit.getValue();
    }
}
