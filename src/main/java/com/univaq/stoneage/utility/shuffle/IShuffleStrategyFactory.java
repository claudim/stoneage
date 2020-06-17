package com.univaq.stoneage.utility.shuffle;

public interface IShuffleStrategyFactory {
    IShuffleStrategy getShuffleStrategy(int playersNumber);
}
