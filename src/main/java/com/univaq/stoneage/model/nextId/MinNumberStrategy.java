package com.univaq.stoneage.model.nextId;

public class MinNumberStrategy implements IGetNextIdStrategy {
    @Override
    public int getNextId(int min, int max) {
        return min;
    }
}
