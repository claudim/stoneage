package com.univaq.stoneage.ui.tokens;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.utility.TokenState;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Forest token grid. Display tokens and listen for changes in the model grid
 */
public class UGrid extends JPanel implements PropertyChangeListener {

    public ArrayList<UTokenForest> getUTokenForests() {
        return uTokenForests;
    }

    /* List of forest tokens */
    private ArrayList<UTokenForest> uTokenForests;

    /* Panel containing buttons representing tokens*/
    private JPanel gridPanel;

    public void setGridPanel(JPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    public JPanel getGridPanel() {
        return gridPanel;
    }

    /**
     * Initializes tokens grid for displying on the screen
     */
    public void initGrid() {
        this.uTokenForests = new ArrayList<>();
        setGridLayoutBorder();

        for (MTokenForest tf : MStoneAgeGame.getInstance().getAllTokenForest()) {
            UTokenForest buttonTF = new UTokenForest(tf.getValue().toString(), tf.getIdToken());
            tf.addPropertyChangeListener(buttonTF); // add UtokenForest observer  to MtokenForest
            buttonTF.setContentAreaFilled(true);
            buttonTF.setOpaque(true);
            // buttonTF.setBackground(new Color(10, 93, 0));
            // buttonTF.setForeground(Color.ORANGE);
            this.uTokenForests.add(buttonTF);
            gridPanel.add(buttonTF);
        }
    }

    public void disableAllTokens(){
        for (UTokenForest utf : this.uTokenForests) {
            utf.setEnabled(false);
        }
    }

    public void enableAllTokens() {
        for (UTokenForest utf : this.uTokenForests) {
            utf.setEnabled(true);
        }
    }

    public void enableAllTokensFaceDown() {
        for (UTokenForest utf : this.uTokenForests) {
            if (utf.getState().equals(TokenState.FACEDOWN)) {
                utf.setEnabled(true);
            }
        }
    }

    /**
     * Listens for any position change in the model token grid and start the sorting in the ui
     *
     * @param evt event fired in the model
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("shuffleForestToken")) {
            ArrayList<MTokenForest> mTokenForests = (ArrayList<MTokenForest>) evt.getNewValue();
            updateGrid(mTokenForests);
        }
    }

    private void setGridLayoutBorder() {
        gridPanel.removeAll();
        gridPanel.setLayout(new GridLayout(4, 4, 15, 5));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(40, 150, 40, 150));
    }

    /**
     * Ask for sorting tokens according to model grind and repaint the view
     *
     * @param mTokenForests
     */
    public void updateGrid(ArrayList<MTokenForest> mTokenForests) {
        sortToken(mTokenForests, uTokenForests);
        for (UTokenForest uTokenForest : this.uTokenForests) {
            gridPanel.add(uTokenForest);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    /**
     * Sorts tokens int he ui according to the list of tokens received by the model
     *
     * @param mTokenForests List of tokens received by the model
     * @param uTokenForests List of tokens in the ui
     */
    private void sortToken(ArrayList<MTokenForest> mTokenForests, ArrayList<UTokenForest> uTokenForests) {
        for (int j = 0; j < mTokenForests.size(); j++) {
            int idToken = mTokenForests.get(j).getIdToken();
            UTokenForest tempUTokenForest = null;
            for (int i = 0; tempUTokenForest == null && i < uTokenForests.size(); i++) {
                UTokenForest uTokenForest = uTokenForests.get(i);
                if (uTokenForest.getIdToken() == idToken) {
                    tempUTokenForest = uTokenForests.get(j);
                    uTokenForests.remove(j);
                    uTokenForests.add(j, uTokenForest);
                    uTokenForests.remove(i);
                    uTokenForests.add(i, tempUTokenForest);
                }
            }
            tempUTokenForest = null;
        }
    }
}
