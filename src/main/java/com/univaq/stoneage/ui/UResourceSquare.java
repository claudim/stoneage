package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.squares.MResourceSquare;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class UResourceSquare extends USquare {

    private JPanel ResourcePane;
    private JLabel resourceName;
    private JLabel numResources;

    public UResourceSquare(String name) {
        super(name);
        childPanel.add(ResourcePane);
    }

    public JLabel getResourceName() {
        return resourceName;
    }

    public void setResourceName(JLabel resourceName) {
        this.resourceName = resourceName;
    }

    public JLabel getNumResources() {
        return numResources;
    }

    public void setNumResources(JLabel numResources) {
        this.numResources = numResources;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName().equals("initResource")) {
            MResourceSquare mResourceSquare = (MResourceSquare) propertyChangeEvent.getSource();
            resourceName.setText(mResourceSquare.getm_resourceType());
        }
        numResources.setText(propertyChangeEvent.getNewValue().toString());

    }

}
