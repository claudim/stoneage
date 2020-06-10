package com.univaq.stoneage.model.shuffle;

import java.util.List;

public interface IShuffleStrategy {
    void shuffle(List<?> list);

    /**
     * checking for failover of shuffling service
     *
     * @return false if failed, true otherwise
     */
    boolean getStatus();
}
