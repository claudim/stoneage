package com.univaq.stoneage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "resource")
public class MResource implements Serializable {
    @Id
    @Column(name = "resource_type", nullable = true, unique = true, length = 30)
    private String m_type;

    public MResource() {

    }

    public MResource(String m_type) {
        this.m_type = m_type;
    }

    public String getM_type() {
        return m_type;
    }

    public void setM_type(String m_type) {
        this.m_type = m_type;
    }


}
