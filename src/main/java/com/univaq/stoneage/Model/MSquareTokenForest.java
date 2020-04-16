package com.univaq.stoneage.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("squaretokenforest")
public class MSquareTokenForest extends MTokenForest<String> {

    @Column(name = "value")
    private String m_squareName;

    public MSquareTokenForest(int position, String tokenForestValue) {
        super(position);
        this.m_squareName = tokenForestValue;
    }

    public String getM_squareName() {
        return m_squareName;
    }

    public void setM_squareName(String m_squareName) {
        this.m_squareName = m_squareName;
    }

    @Override
    public String getValue() {
        return this.m_squareName;
    }

    @Override
    public void setValue(String value) {
        this.m_squareName = value;
    }
}