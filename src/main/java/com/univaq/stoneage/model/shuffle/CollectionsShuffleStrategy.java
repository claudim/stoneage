package com.univaq.stoneage.model.shuffle;

import java.util.Collections;
import java.util.List;

public class CollectionsShuffleStrategy implements IShuffleStrategy {
    @Override
    public void shuffle(List<?> list) {
        Collections.shuffle(list);
    }

    @Override
    public boolean getStatus() {
        return true;
    }
}
