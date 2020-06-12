package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.hutTokens.MHutToken;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Java class to manage player's resources
 */
public class MSettlement {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final ArrayList<MHutToken> m_builtHutTokens;
    private ArrayList<MResource> m_resources;
    private String m_name;

    public MSettlement(String a_name) {
        this.m_name = a_name;
        this.m_resources = new ArrayList<>();
        this.m_builtHutTokens = new ArrayList<>();
    }

    public ArrayList<MResource> getM_resources() {
        return m_resources;
    }

    public void setM_resources(ArrayList<MResource> m_resources) {
        this.m_resources = m_resources;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public ArrayList<MHutToken> getM_builtHutTokens() {
        return m_builtHutTokens;
    }

    /**
     * Add the resource to the settlement and notify all the observer
     *
     * @param resource The resource to add
     */
    public void addResource(MResource resource) {
        String type = resource.getM_type();
        int count = resourceTypeCounter(type);
        m_resources.add(resource);
        //notifyPropertyChangeListener("insertResource", resource, count + 1);
        notifyPropertyChangeListener("resource", null, resource);

    }

    /**
     * Remove the resource from the settlement and notify all the observer
     *
     * @param resource The reource to remove
     */
    public void removeResource(MResource resource) {
        String type = resource.getM_type();
        int count = resourceTypeCounter(type);
        m_resources.remove(resource);
        notifyPropertyChangeListener("resource", resource, null);
    }

    /**
     * Steal the resource from the settlement and notify all the observer
     *
     * @param resource The reource to remove
     */
    public void stealResource(MResource resource) {
        m_resources.remove(resource);
        notifyPropertyChangeListener("stealResource", resource, null);
    }

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

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

//    public void notifyPropertyChangeListener(String propertyName, int oldResourceNumber, int newResourceNumber) {
//        support.firePropertyChange(propertyName, oldResourceNumber, newResourceNumber);
//    }

    public void notifyPropertyChangeListener(String propertyName, Object oldValue, Object newValue) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    }


//    public void addHutToken(MHutToken mHutToken) {
//        m_builtHutTokens.add(mHutToken);
//        notifyPropertyChangeListener("addedHut", m_builtHutTokens.size() - 1, m_builtHutTokens.size());
//        Map<MResource, Integer> hutTokenResources = mHutToken.getM_resources();
//        hutTokenResources.forEach((key, value) -> {
//            int i = 0;
//            Iterator it = m_resources.iterator();
//            while (i < value && it.hasNext()) {
//                MResource res = (MResource) it.next();
//                if (res.getM_type().equals(key.getM_type())) {
//                    removeResource(res);
//                    i++;
//                }
//            }
//        });
//    }

    public int resourceTypeCounter(String type) {
        int x = (int) m_resources.stream().filter(mResource -> mResource.getM_type().equals(type)).count();
        //System.out.println(type + ": " + x);
        return x;
    }

    public ArrayList<MResource> getAllResourcesOfType(String type) {
        ArrayList<MResource> resourcesToReturn = new ArrayList<>();
        for (MResource resource : m_resources) {
            if (resource.getM_type().equals(type)) {
                resourcesToReturn.add(resource);
            }
        }
        return resourcesToReturn;
    }

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

