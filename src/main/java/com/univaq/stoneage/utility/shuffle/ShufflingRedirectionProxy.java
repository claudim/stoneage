package com.univaq.stoneage.utility.shuffle;

import java.util.List;

/**
 * It is responsible to make a redirection proxy for the shuffing.
 */
public class ShufflingRedirectionProxy implements IShuffleStrategy {
    private final IShuffleStrategy externalShuffling;
    private final IShuffleStrategy localShuffling;

    /**
     * Constructor.
     *
     * @param externalShuffling The adapter shuffle to an external service
     * @param localShuffling    The local shuffle strategy
     */
    public ShufflingRedirectionProxy(IShuffleStrategy externalShuffling, IShuffleStrategy localShuffling) {
        this.externalShuffling = externalShuffling;
        this.localShuffling = localShuffling;
    }

    /**
     * Shuffle the list of object. Try to use the shuffling of the external service. In case of failover, use the local strategy to shuffle.
     *
     * @param list The list of object to shuffle
     */
    @Override
    public void shuffle(List<?> list) {

        externalShuffling.shuffle(list);
        if (!externalShuffling.getStatus())
            localShuffling.shuffle(list);

    }

    /**
     * Checking for failover of shuffling.
     *
     * @return false if failed, true otherwise
     */
    @Override
    public boolean getStatus() {
        return true;
    }
}
