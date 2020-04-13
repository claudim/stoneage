package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MPlayer;
import com.univaq.stoneage.Model.MStoneAgeGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UGameBoard extends JPanel {

    private ArrayList<UPlayer> players = new ArrayList<>();

    private JPanel gameContentPane;
    private UBoard uBoard;
    private UGrid uGrid;

    public UGrid getuGrid() {
        return uGrid;
    }

    public void initGameBoard(){

        this.uGrid = new UGrid();
        uGrid.initGrid();

        this.uBoard = new UBoard();
        this.uBoard.initSquares();

        double i =  this.uBoard.getSquareNumber()/4.0;
        int inf = (int)i;
        int sup = inf+1;

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(uGrid.getGridPanel(), BorderLayout.CENTER );

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(inf, 1));

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, sup));

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(inf, 1));

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, sup));

        int num =  this.uBoard.getSquareNumber();
        for(int j = 0; j<num; j++)
        {
            if (j<sup)
            {
                southPanel.add(this.uBoard.getBoardPanel().getComponent(0),0); // cantiere, cane, sorpresa
            }
            else if (j<(inf+sup))
            {
                westPanel.add(this.uBoard.getBoardPanel().getComponent(0),0); // prateria e foresta
            }
            else if(j<(2*sup+inf))
            {
                northPanel.add(this.uBoard.getBoardPanel().getComponent(0));
            }
            else {
                eastPanel.add(this.uBoard.getBoardPanel().getComponent(0)); // battaglia, fiume
            }
        }
        centerPanel.add(westPanel, BorderLayout.WEST);
        centerPanel.add(northPanel, BorderLayout.NORTH);
        centerPanel.add(eastPanel, BorderLayout.EAST);
        centerPanel.add(southPanel, BorderLayout.SOUTH);
        gameContentPane.add(centerPanel,BorderLayout.CENTER);
        this.initPlayers();
     }


    public JPanel getGameContentPane() {
        return this.gameContentPane;
    }

    public void initPlayers(){
        int i = 1;
        ArrayList<MPlayer> mPlayers = MStoneAgeGame.getInstance().getM_players();
        MPlayer currentPlayer = MStoneAgeGame.getInstance().getCurrentPlayer();
       // int numPlayers = mPlayers.size();
        for (MPlayer p: mPlayers){
            UPlayer uPlayer = new UPlayer();
            uPlayer.setName(p.getMarkerName());
            uPlayer.playerStyle();

            UMarker uMarker = new UMarker();
            uMarker.setMarkerName(p.getMarkerName());
            uMarker.markerStyle();

            if(currentPlayer.equals(p))
            {
                uPlayer.setCurrentPlayer(true);
               // uBoard.setCurrentMarker(uMarker);

            }
            this.players.add(uPlayer);

            USquare usq = this.uBoard.findUSquareByName(p.getM_marker().getCurrentSquare().getM_name());
            p.getM_marker().addPropertyChangeListener(this.uBoard); // add uboard as a MMarker observer
            usq.getuMarkers().add(uMarker);
            usq.getMarkersPanel().setLayout(new GridLayout());
            usq.getMarkersPanel().add(uMarker.getMarkerPanel());
            switch (i) {
                case 1: {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.SOUTH);
                    //gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.AFTER_LAST_LINE);
                    i++;
                    break;
                }
                case 2: {
//                    uPlayer.getPlayerPanel().setLayout(new BoxLayout(uPlayer.getPlayerPanel(), BoxLayout.PAGE_AXIS));
//                    uPlayer.getPlayerPanel().add(uMarker.getMarkerPanel());
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.WEST);
                    //gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.AFTER_LAST_LINE);
                    i++;
                    break;
                }
                case 3:
                {
                    //gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.NORTH);
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

}
