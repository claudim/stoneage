package com.univaq.stoneage.model.nextId;

public interface IGetNextIdStrategy {
    int getNextId(int min, int max);
}
