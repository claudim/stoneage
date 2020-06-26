package com.univaq.stoneage.utility.nextId;

import java.util.List;

/**
 * Strategy that returns first index
 */
public class GetFirstIdStrategy implements IGetNextIdStrategy {

    /**
     * Returns the first index in range
     *
     * @param min inferior bound
     * @param max superior bound
     * @return first index in range
     */
    @Override
    public int getNextId(int min, int max) {
        return min;
    }

    /**
     * Returns first index in list
     *
     * @param list list in which search the next id
     * @return first index in given list
     */
    @Override
    public int getNextId(List<?> list) {
        return 0;
    }
}
