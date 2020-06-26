package com.univaq.stoneage.utility.nextId;

import java.util.List;
import java.util.Random;

/**
 * Strategy that provide a random index for a list if passed, it can also provide random int in a range
 */
public class GetRandomIdStrategy implements IGetNextIdStrategy {

    /**
     * Get random integer within a range
     *
     * @param min inferior bound
     * @param max superior bound
     * @return random integer within given range
     */
    @Override
    public int getNextId(int min, int max) {
        Random rand = new Random();
        //nextInt(int bound):  il valore generato è compreso tra 0 incluso e il valore bound specificato escluso per cui per [min, max] è necessario nextInt(max+min+1) - min
        return rand.nextInt(max + min + 1) - min;
    }

    /**
     * Get random index in given list
     *
     * @param list list in which search the next id
     * @return random index in given list
     */
    @Override
    public int getNextId(List<?> list) {
        Random rand = new Random();
        return rand.nextInt(list.size());
    }
}
