package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MPlayer;
import com.univaq.stoneage.Model.MStoneAgeGame;
import com.univaq.stoneage.Model.MTokenForest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UGameBoard extends JPanel {

    private ArrayList<UPlayer> players = new ArrayList<>();
    private JPanel gameContentPane;


    public void initGameBoard(){

        UGrid grid = new UGrid();
        grid.initGrid();

        UBoard board = new UBoard();
        board.initSquares();

        double i =  board.getSquareNumber()/4.0;
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

        int num =  board.getSquareNumber();
        for(int j = 0; j<num; j++)
        {
            board.getBoardPanel().getComponents();
            int f = num-j-1;
            if (j<inf)
            {
                westPanel.add(board.getBoardPanel().getComponent(f));
            }
            else if (j<(inf+sup))
            {
                northPanel.add(board.getBoardPanel().getComponent(f));
            }
            else if(j<(2*inf+sup))
            {
                eastPanel.add(board.getBoardPanel().getComponent(f));
            }
            else {
                southPanel.add(board.getBoardPanel().getComponent(f));
            }
        }
        centerPanel.add(westPanel, BorderLayout.WEST);
        centerPanel.add(northPanel, BorderLayout.NORTH);
        centerPanel.add(eastPanel, BorderLayout.EAST);
        centerPanel.add(southPanel, BorderLayout.SOUTH);
        gameContentPane.add(centerPanel,BorderLayout.CENTER);
        this.initPlayersMarker();


     }


    public JPanel getGameContentPane() {
        return this.gameContentPane;
    }

    public void initPlayersMarker(){
        int i = 1;
        ArrayList<MPlayer> mPlayers = MStoneAgeGame.getInstance().getM_players();
       // int numPlayers = mPlayers.size();
        for (MPlayer p: mPlayers){
            UPlayer uPlayer = new UPlayer();
            uPlayer.setName(p.getMarkerName());
            this.players.add(uPlayer);
            switch (i)
            {
                case 1:
                {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.SOUTH);
                    i++;
                    break;
                }
                case 2: {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.WEST);
                    i++;
                    break;
                }
                case 3:
                {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.NORTH);
                    i++;
                    break;
                }
                default: {
                    gameContentPane.add(uPlayer.getPlayerPanel(), BorderLayout.EAST);
                    break;
                }
            }
            UMarker uMarker = new UMarker();

//            buttonTF.setContentAreaFilled(true);
//            buttonTF.setOpaque(true);
//            buttonTF.setBackground(new Color(10,93,0));
//            buttonTF.setForeground(Color.ORANGE);
//            gridPanel.add(buttonTF);
        };
    }

}
