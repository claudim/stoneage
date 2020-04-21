package com.univaq.stoneage.model;

/**
 * Define a common interface to manage the choice of the next player
 */
public interface MINextPlayerStrategy {
    MPlayer getCurrentPlayer();

    MPlayer getNextPlayer();
}
