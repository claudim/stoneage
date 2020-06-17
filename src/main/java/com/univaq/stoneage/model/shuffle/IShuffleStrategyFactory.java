package com.univaq.stoneage.model.shuffle;

public interface IShuffleStrategyFactory {
    IShuffleStrategy getShuffleStrategy(int playersNumber);
}
