package com.univaq.stoneage.model.players.playerTurning;

import com.univaq.stoneage.model.players.MPlayer;

import java.util.ArrayList;

/**
 * Abstract Strategy class to identify the correct playing order of the players
 */
public abstract class MNextPlayerStrategy implements MINextPlayerStrategy {
  //protected ArrayList<MPlayer> sortedPlayer;
  //protected MPlayer currentPlayer;


//    public MNextPlayerStrategy(ArrayList<MPlayer> players) {
//        this.sortedPlayer = players;
//        this.currentPlayer = null;
//        this.support = new PropertyChangeSupport(this);
//    }

  public MNextPlayerStrategy() {
  }

//    public ArrayList<MPlayer> getSortedPlayer() {
//        return sortedPlayer;
//    }

//    public abstract ArrayList<MPlayer> getSortedPlayer(ArrayList<MPlayer> players);

//    public void setSortedPlayer(ArrayList<MPlayer> sortedPlayer) {
//        this.sortedPlayer = sortedPlayer;
//    }

  /**
   * Sort players according to the strategy implementation
   */
  public abstract ArrayList<MPlayer> sortPlayers(ArrayList<MPlayer> players);

  /**
   * Return the index of the Player playing active turn
   *
   * @return index index of active player
   */
  public abstract int getIndexActivePlayer();

  /**
   * Return the index of the next player according to the implemented strategy
   *
   * @return Index of next player to play
   */
  public abstract int getIndexNextPlayer();

//    public void addPropertyChangeListener(PropertyChangeListener pcl) {
//        support.addPropertyChangeListener(pcl);
//    }
//
//    public void removePropertyChangeListener(PropertyChangeListener pcl) {
//        support.removePropertyChangeListener(pcl);
//    }
//
//    public void setCurrentPlayer(MPlayer player) {
//        this.notifyPropertyChange(player);
//        this.currentPlayer = player;
//    }

//    public void notifyPropertyChange(MPlayer currentPlayer) {
//        if (currentPlayer != null && this.currentPlayer != null)
//            support.firePropertyChange("currentPlayer", this.currentPlayer.getMarkerName(), currentPlayer.getMarkerName());
//        else if (currentPlayer != null)
//            support.firePropertyChange("currentPlayer", "", currentPlayer.getMarkerName());
//
//
//    }
}
