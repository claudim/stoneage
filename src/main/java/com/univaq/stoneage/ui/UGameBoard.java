package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.ui.players.UMarker;
import com.univaq.stoneage.ui.players.UPlayer;
import com.univaq.stoneage.ui.squares.UBoard;
import com.univaq.stoneage.ui.squares.USquare;
import com.univaq.stoneage.ui.tokens.UGrid;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Class containing the board, players' settlements and forest token grid
 */
public class UGameBoard extends JPanel implements PropertyChangeListener {

    /* Player list */
    private final ArrayList<UPlayer> uPlayers = new ArrayList<>();

    private JPanel gameContentPane;
    /* the board containing squares */
    private UBoard uBoard;
    /* grid containing forest tokens */
    private UGrid uGrid;

    public UGrid getuGrid() {
        return uGrid;
    }

    /**
     * Initializer for the game board. Initializes GUI players, squares, token grids.
     */
    public void initGameBoard() {

        MStoneAgeGame.getInstance().addPropertyChangeListener(this); // add uboard as a MMarker observer
        this.uGrid = new UGrid();
        uGrid.initGrid();
        MStoneAgeGame.getInstance().getM_grid().addPropertyChangeListener(uGrid);

        this.uBoard = new UBoard();
        this.uBoard.initSquares();

        double i = this.uBoard.getSquareNumber() / 4.0;
        double mod = this.uBoard.getSquareNumber() % 4.0;
        int squaresOnShortSide = (int) (((int) i) - 1 + (mod / 2));
        int squaresOnLongSide = squaresOnShortSide + 2 - (int) mod / 2;

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(uGrid.getGridPanel(), BorderLayout.CENTER);

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(squaresOnShortSide, 1));

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, squaresOnLongSide));

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(squaresOnShortSide, 1));

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, squaresOnLongSide));

        int num =  this.uBoard.getSquareNumber();
        for(int j = 0; j<num; j++) {
            if (j < squaresOnLongSide) {
                southPanel.add(this.uBoard.getBoardPanel().getComponent(0), 0);
            } else if (j < (squaresOnShortSide + squaresOnLongSide)) {
                westPanel.add(this.uBoard.getBoardPanel().getComponent(0), 0);
            } else if (j < (2 * squaresOnLongSide + squaresOnShortSide)) {
                northPanel.add(this.uBoard.getBoardPanel().getComponent(0));
            } else {
                eastPanel.add(this.uBoard.getBoardPanel().getComponent(0));
            }
        }
        centerPanel.add(westPanel, BorderLayout.WEST);
        centerPanel.add(northPanel, BorderLayout.NORTH);
        centerPanel.add(eastPanel, BorderLayout.EAST);
        centerPanel.add(southPanel, BorderLayout.SOUTH);
        gameContentPane.add(centerPanel, BorderLayout.CENTER);
        this.initPlayers();
    }

    public JPanel getGameContentPane() {
        return this.gameContentPane;
    }

    /**
     * Initializes players settlement on the screen asking model facade for players list
     */
    public void initPlayers() {
        int i = 1;
        ArrayList<MPlayer> mPlayers = MStoneAgeGame.getInstance().getM_players();
        MPlayer currentPlayer = MStoneAgeGame.getInstance().getActivePlayer();
        for (MPlayer p : mPlayers) {
            UPlayer uPlayer = new UPlayer();
            uPlayer.setName(p.getMarkerName());
            uPlayer.playerStyle();

            UMarker uMarker = new UMarker();
            uMarker.setMarkerName(p.getMarkerName());
            uMarker.markerStyle();

            if(currentPlayer.equals(p)) {
                uPlayer.setCurrentPlayer(true);
            }
            p.getM_settlement().addPropertyChangeListener(uPlayer);
            this.uPlayers.add(uPlayer);

            USquare usq = this.uBoard.findUSquareByName(p.getM_marker().getCurrentSquare().getM_name());
            p.getM_marker().addPropertyChangeListener(this.uBoard); // add uboard as a MMarker observer
            usq.getuMarkers().add(uMarker);
            usq.getMarkersPanel().setLayout(new GridLayout());
            usq.getMarkersPanel().add(uMarker.getMarkerPanel());
            switch (i) {
                case 1: {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.SOUTH);
                    i++;
                    break;
                }
                case 2: {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.WEST);
                    i++;
                    break;
                }
                case 3: {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.NORTH);
                    i++;
                    break;
                }
                default: {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.EAST);
                    break;
                }
            }
        }
    }

    /**
     * Observer listening for changes in player turning. Sets current player for each turn
     *
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("activePlayer")) {
            UPlayer newCurrentPlayer = this.findUPlayerByName((String) evt.getNewValue()); // new current player's name
            UPlayer oldCurrentPlayer = this.findUPlayerByName((String) evt.getOldValue());// old current player's name
            if (newCurrentPlayer != null) newCurrentPlayer.setCurrentPlayer(true);
            if (oldCurrentPlayer != null) oldCurrentPlayer.setCurrentPlayer(false);
        }
    }

    /**
     * Searches for the player with the given name
     *
     * @param name name of the player to search
     * @return found player if present , null otherwise
     */
    public UPlayer findUPlayerByName(String name) {
        for (UPlayer player : uPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}
