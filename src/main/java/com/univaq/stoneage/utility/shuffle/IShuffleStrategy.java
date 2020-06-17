package com.univaq.stoneage.utility.shuffle;

import java.util.List;

/**
 * It is a Strategy Interface to shuffle.
 */
public interface IShuffleStrategy {
    /**
     * Shuffle the list of object.
     *
     * @param list The list of object to shuffle
     */
    void shuffle(List<?> list);

    /**
     * Checking for failover of shuffling.
     *
     * @return false if failed, true otherwise
     */
    boolean getStatus();
}
