package com.example.chad.fruitmachine;

/**
 * Created by chad on 04/11/2017.
 */

public class Player {
    private int funds;
    private String name;

    public Player(String name, int funds) {
        this.name = name;
        this.funds = funds;
    }

    public int getFunds() {
        return funds;
    }

    public String getName() {
        return name;
    }

    public void visitAtm(int added) {
        this.funds += added;
    }

    public void payIn(Playable game) {

        this.funds -= game.getCostPerPlay();

    }

    public void runGame(Playable game) {
        game.play();
    }

    public void collectWinnings(Playable game) {
        this.funds += game.evaluateWinnings();
    }

    public String playGame(Playable game) {
        payIn(game);
        runGame(game);
        collectWinnings(game);
        return game.postGameMessage();
    }
}
