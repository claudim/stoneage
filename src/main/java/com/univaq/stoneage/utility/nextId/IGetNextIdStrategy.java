package com.univaq.stoneage.utility.nextId;

import java.util.List;

/**
 * Interface defining methods implemented in every strategy responsible to find the next element or id
 * in a list of objects
 */
public interface IGetNextIdStrategy {
    /**
     * Choose an id in a range
     *
     * @param min inferior bound
     * @param max superior bound
     * @return int id
     */
    int getNextId(int min, int max);

    /**
     * Find next id in a list of objects
     *
     * @param list list in which search the next id
     * @return id
     */
    int getNextId(List<Object> list);
}
