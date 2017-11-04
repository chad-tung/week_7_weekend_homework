package com.example.chad.fruitmachine;

/**
 * Created by chad on 03/11/2017.
 */

public enum Fruit {

    SEVEN(100),
    BELL(50),
    BAR(20),
    STRAWBERRY(15),
    BANANA(10),
    GRAPES(8),
    WATERMELON(6),
    PEAR(4),
    APPLE(2);

    private int value;

    Fruit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}