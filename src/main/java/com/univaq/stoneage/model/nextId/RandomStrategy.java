package com.univaq.stoneage.model.nextId;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements IGetNextIdStrategy {
    @Override
    public int getNextId(int min, int max) {
        Random rand = new Random();
        //nextInt(int bound):  il valore generato è compreso tra 0 incluso e il valore bound specificato escluso per cui per [min, max] è necessario nextInt(max+min+1) - min
        return rand.nextInt(max + min + 1) - min;
    }

    @Override
    public int getNextId(List<Object> list) {
        Random rand = new Random();
        return rand.nextInt(list.size());
    }
}
