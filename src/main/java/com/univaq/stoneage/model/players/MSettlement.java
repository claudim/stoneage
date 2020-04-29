package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MResource;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

/**
 * Java class to manage player's resources
 */
public class MSettlement {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Map<String, Integer> m_resources;
    private String m_name;

    public MSettlement(String a_name) {
        this.m_name = a_name;
        this.m_resources = new HashMap<>();
        this.m_resources.put("dente", 0);
        this.m_resources.put("bacca", 0);
        this.m_resources.put("anfora", 0);
        this.m_resources.put("freccia", 0);
        this.m_resources.put("pesce", 0);
    }

    public Map<String, Integer> getM_resources() {
        return m_resources;
    }

    public void setM_resources(Map<String, Integer> m_resources) {
        this.m_resources = m_resources;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    /**
     * Add the resource to the settlement
     *
     * @param resource The resource to add
     */
    public void addResource(MResource resource) {
        String type = resource.getM_type();
        int count = m_resources.containsKey(type) ? m_resources.get(type) : 0;
        m_resources.put(type, count + 1);
        notifyPropertyChangeListener(type, count, count + 1);
    }

    /**
     * Remove the resource from the settlement
     *
     * @param resource The reource to remove
     */
    public void removeResource(MResource resource) {
        String type = resource.getM_type();
        int count = m_resources.containsKey(type) ? m_resources.get(type) : 0;
        if (count > 0)
            m_resources.put(type, count - 1);
        notifyPropertyChangeListener(type, count, count - 1);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void notifyPropertyChangeListener(String propertyName, int oldResourceNumber, int newResourceNumber) {
        support.firePropertyChange(propertyName, oldResourceNumber, newResourceNumber);
    }


}
