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


    public void initGameBoard(){

        UGrid grid = new UGrid();
        grid.initGrid();

        this.uBoard = new UBoard();
        this.uBoard.initSquares();

        double i =  this.uBoard.getSquareNumber()/4.0;
        int inf = (int)i;
        int sup = inf+1;

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(grid.getGridPanel(), BorderLayout.CENTER );

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
            this.uBoard.getBoardPanel().getComponents();
            int f = num-j-1;
            if (j<inf)
            {
                westPanel.add(this.uBoard.getBoardPanel().getComponent(f));
            }
            else if (j<(inf+sup))
            {
                northPanel.add(this.uBoard.getBoardPanel().getComponent(f));
            }
            else if(j<(2*inf+sup))
            {
                eastPanel.add(this.uBoard.getBoardPanel().getComponent(f));
            }
            else {
                southPanel.add(this.uBoard.getBoardPanel().getComponent(f));
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
       // int numPlayers = mPlayers.size();
        for (MPlayer p: mPlayers){
            UPlayer uPlayer = new UPlayer();
            uPlayer.setName(p.getMarkerName());
            uPlayer.playerStyle();
            this.players.add(uPlayer);
            UMarker uMarker = new UMarker();
            uMarker.setMarkerName(p.getMarkerName());
            uMarker.markerStyle();
            USquare usq = this.uBoard.findUSquareByName(p.getM_marker().getCurrentSquare().getM_name());
            usq.getSquarePane().setLayout(new GridLayout());
            usq.getSquarePane().add(uMarker.getMarkerPanel());
            switch (i)
            {
                case 1:
                {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.SOUTH);
                    i++;
                    break;
                }
                case 2: {
//                    uPlayer.getPlayerPanel().setLayout(new BoxLayout(uPlayer.getPlayerPanel(), BoxLayout.PAGE_AXIS));
//                    uPlayer.getPlayerPanel().add(uMarker.getMarkerPanel());
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.WEST);
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
        };
    }

}
