package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.gameState.StealingResourceGameState;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class UMainFrame extends JFrame implements PropertyChangeListener {

    //private JPanel mainContainer;
    private final JPanel mainContainer1;
    private final JLayeredPane mainContainer;

    private UMainFrame() {
        super("Stone Age Game");
        mainContainer1 = new JPanel();
        mainContainer = new JLayeredPane();
        this.makeFrameFullDisplay();
        //close window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // minimize window
        this.setState(Frame.ICONIFIED);
        //maximize window
        this.setState(Frame.NORMAL);

    }

    private static UMainFrame instance;

    private UGameBoard uGameBoard;

    public static UMainFrame getInstance() {
        if (instance == null) {
            instance = new UMainFrame();
        }
        return instance;
    }

    public JLayeredPane getMainContainer() {
        return mainContainer;
    }

    public void setStartPage() {
        this.replacePanel(new UStartGame().getContentPane());
    }

    public void setGamePage() {
        this.uGameBoard = new UGameBoard();
        this.uGameBoard.initGameBoard();
        this.getContentPane().removeAll();

        FrameDimension frameDimension = new FrameDimension().invoke();
        int height = frameDimension.getHeight();
        int width = frameDimension.getWidth();
        this.uGameBoard.getGameContentPane().setBounds(0, 0, width, height);

        mainContainer.add(this.uGameBoard.getGameContentPane(), JLayeredPane.DEFAULT_LAYER);
        this.getContentPane().add(mainContainer);
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

    private void replacePanel(JPanel aPanel) {
        this.getContentPane().removeAll();
        this.addPanel(aPanel);
    }

    public UGameBoard getuGameBoard() {
        return uGameBoard;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("changeState")) {
            if (evt.getNewValue().getClass().getSimpleName().equals(StealingResourceGameState.class.getSimpleName())) {
                UStealResource uStealResource = new UStealResource();
                FrameDimension frameDimension = new FrameDimension().invoke();
                uStealResource.getStealResourcePanel().setBounds(0, 0, frameDimension.getWidth(), frameDimension.getHeight());
                mainContainer.add(uStealResource.getStealResourcePanel(), JLayeredPane.POPUP_LAYER);
            }
        }
    }

    private class FrameDimension {
        private int height;
        private int width;

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public FrameDimension invoke() {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int widthToSubtract = (int) screenSize.getWidth() - UMainFrame.this.getContentPane().getSize().width;
            int heightToSubtract = screenSize.height - UMainFrame.this.getContentPane().getSize().height;
            height = screenSize.height - heightToSubtract;
            width = screenSize.width - widthToSubtract;
            return this;
        }
    }
}
