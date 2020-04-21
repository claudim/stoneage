package com.univaq.stoneage.model;

import java.beans.PropertyChangeListener;

/**
 * Define a common interface to manage the choice of the next player
 */
public interface MINextPlayerStrategy {
    MPlayer getCurrentPlayer();

    MPlayer getNextPlayer();

    void addPropertyChangeListener(PropertyChangeListener pcl);

    void removePropertyChangeListener(PropertyChangeListener pcl);

    void notifyPropertyChange(MPlayer currentPlayer);
}
