package com.univaq.stoneage.model.nextId;

import java.util.List;

public class GetFirstIdStrategy implements IGetNextIdStrategy {
    @Override
    public int getNextId(int min, int max) {
        return min;
    }

    @Override
    public int getNextId(List<Object> list) {
        return 0;
    }
}
