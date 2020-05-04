package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MHutToken;
import com.univaq.stoneage.model.MResource;

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
    //private EnhancedPropertyChangeSupport support = new PropertyChangeSupport(this);
    private final ArrayList<MHutToken> m_hutTokens;
    private ArrayList<MResource> m_resources;
    private String m_name;

    public MSettlement(String a_name) {
        this.m_name = a_name;
        this.m_resources = new ArrayList<>();
        this.m_hutTokens = new ArrayList<>();
    }

//    private ArrayList<MResource> getResourcesFormDB() {
//        ArrayList<MResource> resources = new ArrayList<>();
//        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MResource.class.getSimpleName());
//        resources.addAll(dao.findAll());
//        return resources;
//    }

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
//        notifyPropertyChangeListener(type, count, count - 1);
        //notifyPropertyChangeListener("removeResource", resource, count - 1);
        notifyPropertyChangeListener("resource", resource, null);
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


    public void addHutToken(MHutToken mHutToken) {
        m_hutTokens.add(mHutToken);
        Map<MResource, Integer> hutTokenResources = mHutToken.getM_resources();
        hutTokenResources.forEach((key, value) -> {
            int i = 0;
            Iterator it = m_resources.iterator();
            while (i < value && it.hasNext()) {
                MResource res = (MResource) it.next();
                if (res.getM_type().equals(key.getM_type())) {
                    removeResource(res);
                    i++;
                }
            }
        });
    }

    public int resourceTypeCounter(String type) {
        int x = (int) m_resources.stream().filter(mResource -> mResource.getM_type().equals(type)).count();
        System.out.println(type + ": " + x);
        return x;
    }
}

