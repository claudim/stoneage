package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


public class UMainFrame extends JFrame implements Observer {

    private JPanel mainContainer;

    private static UMainFrame instance;

    public static UMainFrame getInstance() {
        if (instance == null) {
            instance = new UMainFrame();
        }
        return instance;
    }

    private UMainFrame(){
        super("Stone Age Game");
        mainContainer = new JPanel();
        this.makeFrameFullDisplay();
        //close window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // minimize window
        this.setState(Frame.ICONIFIED);
        //maximize window
        this.setState(Frame.NORMAL);

    }

    public void setStartPage(){
        //this.setContentPane(new StartGame().getContentPane());
        this.replacePanel(new UStartGame().getContentPane());
    }

    public void setGamePage(){
        UGameBoard g = new UGameBoard();
        g.initGameBoard();
        this.replacePanel(g.getGameContentPane());


    }

    private void makeFrameFullDisplay() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
    }

    private void makeFrameHalfDisplay() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width/2, screenSize.height/2);
    }

    private void addPanel(JPanel aPanel)
    {
        this.getContentPane().add(aPanel);
    }

    private void replacePanel(JPanel aPanel){
        this.getContentPane().removeAll();
        this.addPanel(aPanel);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
