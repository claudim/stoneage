package com.univaq.stoneage.model;

/**
 * Define a common interface to manage the game turn
 */
public interface MINextPlayerStrategy {
    MPlayer getCurrentPlayer();

    MPlayer getNextPlayer();
}
