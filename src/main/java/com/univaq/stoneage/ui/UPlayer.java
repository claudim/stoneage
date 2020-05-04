package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.utility.PlayerColors;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UPlayer extends JPanel implements PropertyChangeListener {

    private JLabel playerName;
    private JPanel playerPanel;
    private JLabel pesceLabel;
    private JLabel anforaLabel;
    private JLabel denteLabel;
    private JLabel frecciaLabel;
    private JPanel resourcePanel;
    private JPanel baccaPanel;
    private JLabel baccaLabel;
    private JLabel frecciaCounter;
    private JLabel baccaCounter;
    private JPanel frecciaPanel;
    private JPanel pescePanel;
    private JLabel pesceCounter;
    private JPanel anforaPanel;
    private JLabel anforaCounter;
    private JPanel dentePanel;
    private JLabel denteCounter;

    @Override
    public String getName() {
        return name;
    }

    private String name;

    public void playerStyle() {
        String n = name.toUpperCase();
        this.playerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.playerPanel.setPreferredSize(new Dimension(120, 120));
        this.playerName.setBackground(PlayerColors.valueOf(n).markerColor);
        this.playerName.setOpaque(true);
    }

    @Override
    public void setName(String name) {
        this.playerName.setText(name);
        this.name = name;
    }

    public JPanel getPlayerPanel() {
        return playerPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void setCurrentPlayer(boolean currentPlayer) {
        if (currentPlayer) {
            this.playerName.setText(name.toUpperCase());
        } else this.playerName.setText(name.toLowerCase());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        if(!SwingUtilities.isEventDispatchThread())
//        {
//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    propertyChange(evt);
//                }
//            });
//        }
        if (evt.getPropertyName().equals("resource")) {
            if (evt.getNewValue() == null) {
                switch (((MResource) evt.getOldValue()).getM_type()) {
                    case "pesce": {
                        Integer x = Integer.parseInt(pesceCounter.getText());
                        x--;
                        pesceCounter.setText(x.toString());
                        break;
                    }
                    case "anfora": {
                        Integer x = Integer.parseInt(anforaCounter.getText());
                        x--;
                        anforaCounter.setText(x.toString());
                        break;
                    }
                    case "bacca": {
                        Integer x = Integer.parseInt(baccaCounter.getText());
                        x--;
                        baccaCounter.setText(x.toString());
                        break;
                    }
                    case "dente": {
                        Integer x = Integer.parseInt(denteCounter.getText());
                        x--;
                        denteCounter.setText(x.toString());
                        break;
                    }
                    case "freccia": {
                        Integer x = Integer.parseInt(frecciaCounter.getText());
                        x--;
                        frecciaCounter.setText(x.toString());
                        break;
                    }
                    default:
                        break;
                }
            } else {
                switch (((MResource) evt.getNewValue()).getM_type()) {
                    case "pesce": {
                        Integer x = Integer.parseInt(pesceCounter.getText());
                        x++;
                        pesceCounter.setText(x.toString());
                        break;
                    }
                    case "anfora": {
                        Integer x = Integer.parseInt(anforaCounter.getText());
                        x++;
                        anforaCounter.setText(x.toString());
                        break;
                    }
                    case "bacca": {
                        Integer x = Integer.parseInt(baccaCounter.getText());
                        x++;
                        baccaCounter.setText(x.toString());
                        break;
                    }
                    case "dente": {
                        Integer x = Integer.parseInt(denteCounter.getText());
                        x++;
                        denteCounter.setText(x.toString());
                        break;
                    }
                    case "freccia": {
                        Integer x = Integer.parseInt(frecciaCounter.getText());
                        x++;
                        frecciaCounter.setText(x.toString());
                        break;
                    }
                    default:
                        break;
                }
            }
        }

//        if (evt.getPropertyName().equals("removeResource")|| evt.getPropertyName().equals("insertResource")) {
//            MSettlement mSettlement = (MSettlement) evt.getSource();
//            if (mSettlement.getM_name().equals(name)) {
//                //switch (evt.getPropertyName()) {
//                switch (((MResource) evt.getOldValue()).getM_type()) {
//                    case "pesce": {
//                        pesceCounter.setText(evt.getNewValue().toString());
//                        break;
//                    }
//                    case "anfora": {
//                        anforaCounter.setText(evt.getNewValue().toString());
//                        break;
//                    }
//                    case "bacca": {
//                        baccaCounter.setText(evt.getNewValue().toString());
//                        break;
//                    }
//                    case "dente": {
//                        denteCounter.setText(evt.getNewValue().toString());
//                        break;
//                    }
//                    case "freccia": {
//                        frecciaCounter.setText(evt.getNewValue().toString());
//                        break;
//                    }
//                    default:
//                        break;
//                }
//            }
//        }
    }
}
