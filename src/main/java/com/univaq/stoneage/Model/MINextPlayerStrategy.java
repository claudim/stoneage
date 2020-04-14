package com.univaq.stoneage.Model;

/**
 * Define a common interface to manage the game turn
 */
public interface MINextPlayerStrategy {
    MPlayer getCurrentPlayer();

    MPlayer getNextPlayer();
}
