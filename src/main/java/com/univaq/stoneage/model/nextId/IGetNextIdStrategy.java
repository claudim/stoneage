package com.univaq.stoneage.model.nextId;

import java.util.List;

public interface IGetNextIdStrategy {
    int getNextId(int min, int max);

    int getNextId(List<Object> list);
}
