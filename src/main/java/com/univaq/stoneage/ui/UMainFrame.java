package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.gameState.*;
import com.univaq.stoneage.model.players.MHumanPlayer;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.extraAbilityPlayer.ExtraAbilityPlayerDecorator;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;


public class UMainFrame extends JFrame implements PropertyChangeListener {

    //private JPanel mainContainer;
    private JPanel mainContainer1;
    private JLayeredPane mainContainer;
    private static UMainFrame instance;
    private UGameBoard uGameBoard;

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

    public void setStartPage(String name) {
        UStartGame uStartGame = new UStartGame();
        uStartGame.setWinnerName(name);
        this.replacePanel(uStartGame.getContentPane());
    }

    public void setMainContainer1(JPanel mainContainer1) {
        this.mainContainer1 = mainContainer1;
    }

    public void setMainContainer(JLayeredPane mainContainer) {
        this.mainContainer = mainContainer;
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
            if (evt.getNewValue().getClass().getSimpleName().equals(WaitingForPreyGameState.class.getSimpleName())
                    && MStoneAgeGame.getInstance().getActivePlayer().getClass().getSimpleName().equals(MHumanPlayer.class.getSimpleName())) {
                UStealResource uStealResource = new UStealResource();
                FrameDimension frameDimension = new FrameDimension().invoke();
                uStealResource.getStealResourcePanel().setBounds(0, 0, frameDimension.getWidth(), frameDimension.getHeight());
                mainContainer.add(uStealResource.getStealResourcePanel(), JLayeredPane.POPUP_LAYER);
            }

            if (evt.getNewValue().getClass().getSimpleName().equals(WaitingForTokenForest.class.getSimpleName())) {
                if (MStoneAgeGame.getInstance().getActivePlayer().getClass().getSimpleName().equals(MHumanPlayer.class.getSimpleName())) {
                    // abilita i buttoni dei token coperti
                    UMainFrame.getInstance().getuGameBoard().getuGrid().enableAllTokensFaceDown();
                } else {
                    try {
                        ExtraAbilityPlayerDecorator activePlayer = (ExtraAbilityPlayerDecorator) MStoneAgeGame.getInstance().getActivePlayer();
                        if (activePlayer.getPlayer().getClass().getSimpleName().equals(MHumanPlayer.class.getSimpleName())) {
                            // abilita i buttoni dei token coperti
                            UMainFrame.getInstance().getuGameBoard().getuGrid().enableAllTokensFaceDown();
                        }
                    } catch (Exception e) {
                        // vuol dire che è un emulato o un emulato con abilità quindi lascia tutto disabilitato
                    }
                }

            }
            if (evt.getNewValue().getClass().getSimpleName().equals(OnNewSquareGameState.class.getSimpleName())) {
                // disabilita i buttoni dei token
                UMainFrame.getInstance().getuGameBoard().getuGrid().disableAllTokens();
            }
            if (evt.getNewValue().getClass().getSimpleName().equals(EndTurnGameState.class.getSimpleName())) {
                // disabilita i buttoni dei token
                UMainFrame.getInstance().getuGameBoard().getuGrid().disableAllTokens();
            }

            if (evt.getNewValue().getClass().getSimpleName().equals(EndGameState.class.getSimpleName())) {
                //mostra vittoria del vincitore
                ArrayList<MPlayer> mPlayers = MStoneAgeGame.getInstance().getM_players();
                AtomicReference<String> winnerName = new AtomicReference<>("");
                mPlayers.forEach(mPlayer -> {
                    if (mPlayer.isM_winner()) {
                        winnerName.set(mPlayer.getMarkerName());
                    }
                });
                this.setStartPage(winnerName.toString());
                this.setVisible(true);
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
