package com.univaq.stoneage.utility.shuffle;

public class RedShuffleStrategyFactory implements IShuffleStrategyFactory {
    @Override
    public IShuffleStrategy getShuffleStrategy(int playersNumber) {
        IShuffleStrategy shuffleStrategy;
        switch (playersNumber) {
//            case 2:
//                break;
//            case 3:
//                break;
            case 4:
                IShuffleStrategy externalShuffling = new RandomOrgAdapter();
                IShuffleStrategy localShuffling = new CollectionsShuffleStrategy();
                shuffleStrategy = new ShufflingRedirectionProxy(externalShuffling, localShuffling);
                break;
            default:
                shuffleStrategy = new NoShuffleStrategy();
                break;
        }
        return shuffleStrategy;
    }
}
