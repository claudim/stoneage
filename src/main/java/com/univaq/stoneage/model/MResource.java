package com.univaq.stoneage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Is a persistent entity.
 * It knows its type.
 */
@Entity
@Table(name = "resource")
public class MResource implements Serializable {
    @Id
    @Column(name = "resource_type", nullable = true, unique = true, length = 30)
    private String m_type;

    /**
     * Constructor.
     */
    public MResource() {
    }

    /**
     * Constructor.
     *
     * @param m_type The resource type
     */
    public MResource(String m_type) {
        this.m_type = m_type;
    }

    /**
     * Get the resource type.
     *
     * @return The resource type
     */
    public String getM_type() {
        return m_type;
    }

    /**
     * Set the resource type.
     *
     * @param m_type The resource type
     */
    public void setM_type(String m_type) {
        this.m_type = m_type;
    }
}
