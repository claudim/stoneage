package com.univaq.stoneage.utility;

import java.awt.*;

/**
 * Enum class defining association between player names and marker color
 */
public enum PlayerColors {
    JONO(Color.blue),
    JADA(Color.magenta),
    GUFF(Color.green),
    MARTIN(Color.yellow);

    public final Color markerColor;

    PlayerColors(Color label) {
        this.markerColor = label;
    }
}
