package com.univaq.stoneage.model.shuffle;

import java.util.List;

/**
 * It is a class responsible to shuffle using the Random.org external service.
 */
public class RandomOrgAdapter implements IShuffleStrategy {
    /**
     * Request to Random.org for shuffling the objects.
     *
     * @param list The list of object to shuffle
     */
    @Override
    public void shuffle(List<?> list) {
        //todo implementare la richiesta alla api di random.org
    }

    /**
     * Checking for failover of shuffling service.
     *
     * @return false if failed, true otherwise
     */
    @Override
    public boolean getStatus() {
        return false;
    }
}
