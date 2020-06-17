package com.univaq.stoneage.utility.shuffle;

public class GreenShuffleStrategyFactory implements IShuffleStrategyFactory {
    @Override
    public IShuffleStrategy getShuffleStrategy(int playersNumber) {
        IShuffleStrategy shuffleStrategy;
        switch (playersNumber) {
//            case 2:
//                break;
//            case 3:
//                break;
            case 4:
                shuffleStrategy = new CollectionsShuffleStrategy();
                break;
            default:
                shuffleStrategy = new NoShuffleStrategy();
                break;
        }
        return shuffleStrategy;
    }
}
