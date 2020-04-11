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



//        //c.setLayout(new BorderLayout());
//        mainContainer = new JPanel();
//        StartGame sg = new StartGame();
//        getContentPane().add(sg);
//
//
//        JPanel centroPnl = new JPanel();
//
//
//        JPanel sudPnl = new JPanel();
//        JLabel infoLbl = new JLabel("Selezionare:");
//        JCheckBox opz1Chk = new JCheckBox("Opz1");
//        JCheckBox opz2Chk = new JCheckBox("Opz2");
//        JButton okBtn=new JButton("OK");
//        JButton cancBtn=new JButton("Annulla");
//        JButton centro = new JButton("centro");



       // c.add(nord,BorderLayout.NORTH);
        //c.add(centro, BorderLayout.CENTER);
        //c.add(est,BorderLayout,EAST);
        //c.add(ovest,BorderLayout.WEST);
        //c.add(sud,BorderLayout.SOUTH);

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
