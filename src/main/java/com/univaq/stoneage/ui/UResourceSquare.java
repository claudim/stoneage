package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

/**
 * Represents the resource square on the board
 */
public class UResourceSquare extends USquare {

    private JPanel ResourcePane;
    /* The name of the rourse held*/
    private JLabel resourceName;
    /* The number of held resource */
    private JLabel numResources;

    /**
     * Constructor
     *
     * @param name name
     */
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

    /**
     * Listens for changes on the number of resources on the relative square in the model
     *
     * @param propertyChangeEvent event fired in the model
     */
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName().equals("initResource") || propertyChangeEvent.getPropertyName().equals("incrementResource")) {
            MResourceSquare mResourceSquare = (MResourceSquare) propertyChangeEvent.getSource();
            resourceName.setText(mResourceSquare.getm_resourceType());
        }
        numResources.setText(propertyChangeEvent.getNewValue().toString());
    }

}
