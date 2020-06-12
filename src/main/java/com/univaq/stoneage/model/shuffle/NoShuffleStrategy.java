package com.univaq.stoneage.model.shuffle;

import java.util.List;

/**
 * It is a class responsible to no shuffle.
 */
public class NoShuffleStrategy implements IShuffleStrategy {

    /**
     * No Shuffle the list of object.
     *
     * @param list The list of object to shuffle
     */
    @Override
    public void shuffle(List<?> list) {
        //NO-OP
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
