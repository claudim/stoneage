package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MStoneAgeGame;

import javax.swing.*;
import java.awt.*;

public class UGameBoard extends JPanel {

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

     }


    public JPanel getGameContentPane() {
        return this.gameContentPane;
    }

}
