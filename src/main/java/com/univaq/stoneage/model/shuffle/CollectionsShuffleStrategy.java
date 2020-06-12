package com.univaq.stoneage.model.shuffle;

import java.util.Collections;
import java.util.List;

/**
 * It is a class responsible to shuffle using the Collection.shuffle() method.
 */
public class CollectionsShuffleStrategy implements IShuffleStrategy {
    /**
     * Shuffle the list of object using the Collection.shuffle() method.
     *
     * @param list The list of object to shuffle
     */
    @Override
    public void shuffle(List<?> list) {
        Collections.shuffle(list);
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
