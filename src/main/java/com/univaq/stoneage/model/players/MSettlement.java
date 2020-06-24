package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MHutToken;
import com.univaq.stoneage.model.MResource;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Java class to manage player's resources.
 * It is observable (by ResourceSquare and UPlayer).
 */
public class MSettlement {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final ArrayList<MHutToken> m_builtHutTokens;
    private ArrayList<MResource> m_resources;
    private String m_name;

    /**
     * Constructor.
     *
     * @param a_name The name
     */
    public MSettlement(String a_name) {
        this.m_name = a_name;
        this.m_resources = new ArrayList<>();
        this.m_builtHutTokens = new ArrayList<>();
    }

    /**
     * Get the settlement resources.
     *
     * @return The settlement resources
     */
    public ArrayList<MResource> getM_resources() {
        return m_resources;
    }

    /**
     * Set the resources.
     *
     * @param m_resources The resources to set
     */
    public void setM_resources(ArrayList<MResource> m_resources) {
        this.m_resources = m_resources;
    }

    /**
     * Get the name.
     *
     * @return the name
     */
    public String getM_name() {
        return m_name;
    }

    /**
     * Set the name.
     *
     * @param m_name the name
     */
    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    /**
     * Get the hut token built.
     *
     * @return The hut token built.
     */
    public ArrayList<MHutToken> getM_builtHutTokens() {
        return m_builtHutTokens;
    }

    /**
     * Add the resource to the settlement and notify all the observer.
     *
     * @param resource The resource to add
     */
    public void addResource(MResource resource) {
        m_resources.add(resource);
        //notifyPropertyChangeListener("insertResource", resource, count + 1);
        notifyPropertyChangeListener("resource", null, resource);

    }

    /**
     * Remove the resource from the settlement and notify all the observer.
     *
     * @param resource The resource to remove
     */
    public void removeResource(MResource resource) {
        m_resources.remove(resource);
        notifyPropertyChangeListener("resource", resource, null);
    }

    /**
     * Steal the resource from the settlement and notify all the observer.
     *
     * @param resource The resource to remove
     */
    public void stealResource(MResource resource) {
        m_resources.remove(resource);
        notifyPropertyChangeListener("stealResource", resource, null);
    }

    /**
     * Add an observer to the list only for a specific property.
     *
     * @param propertyName The property name
     * @param pcl          The observer to add
     */
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener pcl) {
        PropertyChangeListener[] propertyChangeListeners = support.getPropertyChangeListeners(propertyName);
        boolean alreadyAdded = false;
        for (PropertyChangeListener propertyChangeListener : propertyChangeListeners) {
            if (propertyChangeListener.equals(pcl)) {
                alreadyAdded = true;
            }
        }
        if (!alreadyAdded) support.addPropertyChangeListener(propertyName, pcl);
    }

    /**
     * Add an observer to the list.
     *
     * @param pcl The observer to add
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    /**
     * Remove an observer from the list.
     *
     * @param pcl The observer to remove
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    /**
     * Notify all the observer for the change of the property.
     *
     * @param property The property name which changed its value
     * @param oldValue The old value of the property
     * @param newValue The new value of the property
     */
    public void notifyPropertyChangeListener(String property, Object oldValue, Object newValue) {
        support.firePropertyChange(property, oldValue, newValue);
    }

    /**
     * Count the resources of the type which is passed as a parameter.
     *
     * @param type The resource type
     * @return The number of the resource.
     */
    public int resourceTypeCounter(String type) {
        return (int) m_resources.stream().filter(mResource -> mResource.getM_type().equals(type)).count();
    }

    /**
     * Get all the resources of the type passed as a parameter.
     *
     * @param type The resource type
     * @return All the resource of the type type
     */
    public ArrayList<MResource> getAllResourcesOfType(String type) {
        ArrayList<MResource> resourcesToReturn = new ArrayList<>();
        for (MResource resource : m_resources) {
            if (resource.getM_type().equals(type)) {
                resourcesToReturn.add(resource);
            }
        }
        return resourcesToReturn;
    }

    /**
     * Add a hut token to the settlement.
     *
     * @param mHutToken The hut token to add
     */
    public void addHutToken(MHutToken mHutToken) {
        m_builtHutTokens.add(mHutToken);
        notifyPropertyChangeListener("addedHut", m_builtHutTokens.size() - 1, m_builtHutTokens.size());
        Map<MResource, Integer> hutTokenResources = mHutToken.getM_resources();
        for (Map.Entry<MResource, Integer> entry : hutTokenResources.entrySet()) {
            MResource key = entry.getKey();
            Integer value = entry.getValue();
            ArrayList<MResource> resources = getAllResourcesOfType(key.getM_type());
            int i = 0;
            Iterator it = resources.iterator();
            while (i < value && it.hasNext()) {
                MResource res = (MResource) it.next();
                removeResource(res);
                i++;
            }
            if (i != value) {
                //there is not enought resource type, so it is necessary use the dog resource
                ArrayList<MResource> dogResources = getAllResourcesOfType("cane");
                Iterator dogIt = dogResources.iterator();
                while (i < value && dogIt.hasNext()) {
                    MResource res = (MResource) dogIt.next();
                    removeResource(res);
                    i++;
                }
            }
        }
    }
}

