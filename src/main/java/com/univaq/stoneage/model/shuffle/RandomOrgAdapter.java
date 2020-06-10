package com.univaq.stoneage.model.shuffle;

import java.util.List;

public class RandomOrgAdapter implements IShuffleStrategy {
    @Override
    public void shuffle(List<?> list) {
        //todo implementare la richiesta alla api di random.org
    }

    @Override
    public boolean getStatus() {
        return false;
    }
}
