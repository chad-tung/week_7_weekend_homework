package com.example.chad.fruitmachine;

/**
 * Created by chad on 05/11/2017.
 */

//Was going to try be ambitious and try polish up blackjack and make a mini-casino, or even make different slot machines...

public interface Playable {

    public String play();

    public int getCostPerPlay();

    public int evaluateWinnings();

    public String postGameMessage();
}
