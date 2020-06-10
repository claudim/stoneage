package com.univaq.stoneage.model.shuffle;

import java.util.List;

public class NoShuffleStrategy implements IShuffleStrategy {
    @Override
    public void shuffle(List<?> list) {
        //NO-OP
    }

    @Override
    public boolean getStatus() {
        return true;
    }
}
