package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MResource;

import java.util.ArrayList;

/**
 * Java class to manage player's resources
 */
public class MSettlement {
    private ArrayList<MResource> m_resources;

    public MSettlement() {
        this.m_resources = new ArrayList<>();
    }

    public ArrayList<MResource> getM_resources() {
        return m_resources;
    }

    public void setM_resources(ArrayList<MResource> m_resources) {
        this.m_resources = m_resources;
    }

    /**
     * Add the resource to the settlement
     *
     * @param resource The resource to add
     */
    public void addResource(MResource resource) {
        m_resources.add(resource);
        int y = 0;
        int x = y;
    }

    /**
     * Remove the resource from the settlement
     *
     * @param resource The reource to remove
     */
    public void removeResource(MResource resource) {
        m_resources.remove(resource);
    }
}
