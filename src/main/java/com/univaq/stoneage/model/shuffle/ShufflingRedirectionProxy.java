package com.univaq.stoneage.model.shuffle;

import java.util.List;

public class ShufflingRedirectionProxy implements IShuffleStrategy {
    private final IShuffleStrategy externalShuffling;
    private final IShuffleStrategy localShuffling;

    public ShufflingRedirectionProxy(IShuffleStrategy externalShuffling, IShuffleStrategy localShuffling) {
        this.externalShuffling = externalShuffling;
        this.localShuffling = localShuffling;
    }

    @Override
    public void shuffle(List<?> list) {

        externalShuffling.shuffle(list);
        if (!externalShuffling.getStatus())
            localShuffling.shuffle(list);

    }

    @Override
    public boolean getStatus() {
        return true;
    }
}
