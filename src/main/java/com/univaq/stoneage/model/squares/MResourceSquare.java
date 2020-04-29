package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.MSettlement;

import javax.persistence.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

@Entity
@DiscriminatorValue(value = "resourcesquare")
public class MResourceSquare extends MSquare {

    @Transient // ignore this property/field
    private final PropertyChangeSupport support = new PropertyChangeSupport(this); // to implement the oberver pattern
    @Column(name = "resource_type")
    private String m_resourceType;
    @Transient
    private ArrayList<MResource> m_resources;


    public MResourceSquare() {
        m_resources = new ArrayList<>();


    }

    public MResourceSquare(String a_type) {
        m_resourceType = a_type;
        m_resources = new ArrayList<>();
    }

    public String getm_resourceType() {
        return m_resourceType;
    }

    public void setm_resourceType(String m_resourceType) {
        this.m_resourceType = m_resourceType;
    }

    public ArrayList<MResource> getM_resources() {
        return m_resources;
    }

    public void setM_resources(ArrayList<MResource> m_resources) {
        this.m_resources = m_resources;
    }

    @Override
    public void doAction(MPlayer mPlayer) {
        MResource resource = m_resources.remove(0);
        if (resource != null) {
            notifyPropertyChange(m_resources.size());
            MSettlement settlement = mPlayer.getM_settlement();
            settlement.addResource(resource);
        } else {
            //steal a resource
        }
    }

    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
        support.firePropertyChange("initResource", 0, this.m_resources.size());
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public void notifyPropertyChange(Object newResourceNumber) {
        //todo la old size è calcolata hard coded
        support.firePropertyChange("resource", this.m_resources.size() + 1, (int) newResourceNumber);
    }

    // after object creation from Hibernate this method is called
    @PostLoad
    public void createResources() {
        int numPlayer = MStoneAgeGame.getInstance().getNumPlayer();
        for (int i = 0; i < numPlayer + 1; i++)
            m_resources.add(new MResource(m_resourceType));
    }

}
