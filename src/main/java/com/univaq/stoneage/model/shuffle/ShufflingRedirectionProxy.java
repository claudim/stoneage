package com.univaq.stoneage.model.shuffle;

import java.util.List;

public class ShufflingRedirectionProxy implements IShuffleStrategy {
    IShuffleStrategy externalShuffling;
    IShuffleStrategy localShuffling;

    public ShufflingRedirectionProxy() {
        this.externalShuffling = new RandomOrgAdapter();
        this.localShuffling = new CollectionsShuffleStrategy();
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
